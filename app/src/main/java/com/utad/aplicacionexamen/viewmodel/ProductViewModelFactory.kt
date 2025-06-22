package com.utad.aplicacionexamen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.utad.aplicacionexamen.data.ProductRepository

class ProductViewModelFactory(
    private val repository: ProductRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(ProductViewModel::class.java) ->
                ProductViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
}
