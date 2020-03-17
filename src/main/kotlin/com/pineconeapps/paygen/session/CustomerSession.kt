package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.CheckedIn
import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.LoginDTO

interface CustomerSession {

    fun findCustomerById(customerId: String):Customer

    fun findCustomerByCpf(cpf: String): Customer

    fun updateCustomer(customer: Customer): Customer

    fun checkReception(customerId: String): CheckedIn?

    fun updateProfile(dto: LoginDTO): Customer

    fun createUser(customer: Customer): Response
}
