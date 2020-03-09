package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Product
import com.pineconeapps.paygen.entity.Response

interface ProductSession {

    fun listProducts(providerId: String): List<Product>

    fun addProduct(providerId: String, product: Product): Response

    fun findProduct(providerId: String, query: String): List<Product>

    fun findProduct(id: String): Product

}