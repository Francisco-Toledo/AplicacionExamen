package com.utad.aplicacionexamen.Model
import retrofit2.http.GET
import retrofit2.http.Path
interface ProductApiService {
    @GET("products/category/{category}")
    suspend fun getProductsByCategory(@Path("category") category: String): List<Product>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
}
}