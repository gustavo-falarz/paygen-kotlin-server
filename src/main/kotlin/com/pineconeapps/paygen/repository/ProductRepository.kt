package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, String> {
    fun findByDescription(name: String): Product
}
