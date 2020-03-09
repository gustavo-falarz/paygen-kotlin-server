package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Customer
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by Headtrap on 15/07/2017.
 */
interface CustomerRepository : MongoRepository<Customer, String> {
    fun findByEmail(email: String): Customer
    fun existsByToken(token: String?): Boolean
}