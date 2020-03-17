package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*


interface CustomerRepository : MongoRepository<Customer, String> {
    fun findByEmail(email: String): Optional<Customer>
    fun findByCpf(cpf: String): Optional<Customer>
}
