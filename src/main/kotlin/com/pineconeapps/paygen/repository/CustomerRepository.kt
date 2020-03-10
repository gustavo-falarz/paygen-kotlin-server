package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Customer
import org.springframework.data.mongodb.repository.MongoRepository


interface CustomerRepository : MongoRepository<Customer, String> {
    fun findByEmail(email: String): Customer
}
