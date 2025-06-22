package com.utad.aplicacionexamen.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.aplicacionexamen.R
import com.utad.aplicacionexamen.viewmodel.ProductViewModel
import com.utad.aplicacionexamen.viewmodel.ProductViewModelFactory
import com.utad.aplicacionexamen.repository.ProductRepository
import com.utad.aplicacionexamen.databinding.ActivityMainBinding
import com.utad.aplicacionexamen.network.RetrofitClient
import com.utad.aplicacionexamen.view.DetailActivity
import com.utad.aplicacionexamen.view.ProductsAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(ProductRepository(RetrofitClient.api))
    }

    private lateinit var adapter: ProductsAdapter   // Implementa tu propio RecyclerView.Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProductsAdapter { product ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("product_id", product.id)
            startActivity(intent)
        }

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        // Observadores
        viewModel.products.observe(this) { adapter.submitList(it) }

        // Categoría por defecto
        viewModel.loadProducts("electronics")
    }

    // ---------- Menú ----------

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val category = when (item.itemId) {
            R.id.menu_electronics      -> "electronics"
            R.id.menu_jewelery        -> "jewelery"
            R.id.menu_mens_clothing   -> "men's clothing"
            R.id.menu_womens_clothing -> "women's clothing"
            else -> return super.onOptionsItemSelected(item)
        }
        viewModel.loadProducts(category)
        return true
    }
}
