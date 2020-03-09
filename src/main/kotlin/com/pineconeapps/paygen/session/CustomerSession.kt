package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.dto.LoginDTO

interface CustomerSession {

    fun findCustomerByCpf(cpf: String): Customer

    fun updateCustomer(customer: Customer): Customer

    fun checkReception(customerId: String): Customer

    fun updateProfile(dto: LoginDTO): Customer

    fun createUser(customer: Customer): Customer


}
