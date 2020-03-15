package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.entity.Product
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.ProductSession
import org.springframework.stereotype.Component

@Component
class ProductSession: ProductSession {
    override fun listProducts(providerId: String): List<Product> {
        TODO("Not yet implemented")
    }

    override fun addProduct(providerId: String, product: Product): Response {
        TODO("Not yet implemented")
    }

    override fun findProduct(providerId: String, query: String): List<Product> {
        TODO("Not yet implemented")
    }

    override fun findProduct(id: String): Product {
        TODO("Not yet implemented")
    }
}