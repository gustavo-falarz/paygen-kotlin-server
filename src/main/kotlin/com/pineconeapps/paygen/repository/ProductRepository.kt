package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Product
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by Headtrap on 15/07/2017.
 */
interface ProductRepository : MongoRepository<Product, String> {
    fun findByDescription(name: String): Product
}