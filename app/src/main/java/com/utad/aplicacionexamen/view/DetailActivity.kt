package com.utad.aplicacionexamen.view

import com.utad.aplicacionexamen.viewmodel.ProductViewModel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.utad.aplicacionexamen.databinding.ActivityDetailBinding
import com.utad.aplicacionexamen.network.RetrofitClient
import com.utad.aplicacionexamen.repository.ProductRepository
import com.utad.aplicacionexamen.viewmodel.ProductViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(ProductRepository(RetrofitClient.api))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("product_id", -1)
        viewModel.loadProductDetail(id)

        viewModel.selectedProduct.observe(this) {
            binding.title.text = it.title
            binding.price.text = "$${it.price}"
            binding.description.text = it.description
            Glide.with(this).load(it.image).into(binding.image)
        }
    }
}