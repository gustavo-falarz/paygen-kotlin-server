package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Transaction
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface TransactionRepository : MongoRepository<Transaction, String> {
    fun findByProviderIdOrderByDateDesc(providerId: String): List<Transaction>
    fun findByDateBetweenAndProviderIdOrderByDateDesc(start: Date, end: Date, providerId: String): List<Transaction>
    fun findByDateBetweenAndCustomerIdOrderByDateDesc(start: Date, end: Date, customerId: String): List<Transaction>
    fun findByCustomerIdOrderByDateDesc(customerId: String): List<Transaction>
}