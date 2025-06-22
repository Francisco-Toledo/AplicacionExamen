package com.utad.aplicacionexamen.viewmodel

import androidx.lifecycle.*
import com.utad.aplicacionexamen.model.Product
import com.utad.aplicacionexamen.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _selectedProduct = MutableLiveData<Product>()
    val selectedProduct: LiveData<Product> = _selectedProduct

   // fun loadProducts(category: String) = viewModelScope.launch {
      //  _products.value = repository.getProductsByCategory(category)
    //}

    fun loadProductDetail(id: Int) = viewModelScope.launch {
        _selectedProduct.value = repository.getProductById(id)
    }

    fun loadProducts(category: String) = viewModelScope.launch {
        try {
            val productos = repository.getProductsByCategory(category)
            _products.value = productos
            // Log para verificar cuántos productos llegan
            android.util.Log.d("ProductViewModel", "Productos cargados para categoría '$category': ${productos.size}")
        } catch (e: Exception) {
            android.util.Log.e("ProductViewModel", "Error cargando productos para categoría '$category'", e)
            _products.value = emptyList()
        }
    }


}
