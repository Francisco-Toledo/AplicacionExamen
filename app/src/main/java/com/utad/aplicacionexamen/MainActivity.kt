package com.utad.aplicacionexamen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.aplicacionexamen.Repository.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        private lateinit var binding: ActivityMainBinding
        private val viewModel: ProductViewModel by viewModels {
            ProductViewModelFactory(ProductRepository(RetrofitClient.api))
        }

        private lateinit var adapter: ProductsAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            adapter = ProductsAdapter { product ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("product_id", product.id)
                startActivity(intent)
            }

            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = adapter

            viewModel.products.observe(this) {
                adapter.submitList(it)
            }

            viewModel.loadProducts("electronics") // carga por defecto
        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            val category = when (item.itemId) {
                R.id.menu_electronics -> "electronics"
                R.id.menu_jewelery -> "jewelery"
                R.id.menu_mens_clothing -> "men's clothing"
                R.id.menu_womens_clothing -> "women's clothing"
                else -> return super.onOptionsItemSelected(item)
            }
            viewModel.loadProducts(category)
            return true
        }
    }