package com.utad.aplicacionexamen.ui

import androidx.lifecycle.*
import com.utad.aplicacionexamen.data.ProductRepository
import com.utad.aplicacionexamen.Model.Product
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _selectedProduct = MutableLiveData<Product>()
    val selectedProduct: LiveData<Product> = _selectedProduct

    fun loadProducts(category: String) = viewModelScope.launch {
        _products.value = repository.getProductsByCategory(category)
    }

    fun loadProductDetail(id: Int) = viewModelScope.launch {
        _selectedProduct.value = repository.getProductById(id)
    }
}
