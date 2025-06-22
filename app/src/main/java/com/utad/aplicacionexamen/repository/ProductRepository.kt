package com.utad.aplicacionexamen.ViewModel

import com.utad.aplicacionexamen.Model.Product
import com.utad.aplicacionexamen.network.ProductApiService

class ProductRepository(
    private val api: ProductApiService
) {

    suspend fun getProductsByCategory(category: String): List<Product> =
        api.getProductsByCategory(category)

    suspend fun getProductById(id: Int): Product =
        api.getProductById(id)
}
