package com.utad.aplicacionexamen.repository

import com.utad.aplicacionexamen.model.Product
import com.utad.aplicacionexamen.network.ProductApiService

class ProductRepository(
    private val api: ProductApiService
) {

    suspend fun getProductsByCategory(category: String): List<Product> =
        api.getProductsByCategory(category)

    suspend fun getProductById(id: Int): Product =
        api.getProductById(id)
}
