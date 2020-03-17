package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.controller.BaseSession
import com.pineconeapps.paygen.entity.CheckedIn
import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.LoginDTO
import com.pineconeapps.paygen.repository.CustomerRepository
import com.pineconeapps.paygen.session.CustomerSession
import org.springframework.stereotype.Component


@Component
class CustomerSession(val repository: CustomerRepository) : BaseSession(), CustomerSession {

    override fun findCustomerById(customerId: String): Customer {
        val customer = repository.findByEmail(customerId)
        customer.exists(error("error.customer-not-found"))
        return customer.get()
    }

    override fun checkReception(customerId: String): CheckedIn? {
        val customer = findCustomerById(customerId)
        return customer.checkedIn
    }

    override fun updateCustomer(customer: Customer): Customer {
        TODO("Not yet implemented")
    }

    override fun updateProfile(dto: LoginDTO): Customer {
        TODO("Not yet implemented")
    }

    override fun createUser(customer: Customer): Response {
        val existingCustomer = repository.findByEmail(customer.email)
        existingCustomer.checkDuplicate(error("error.user-registered"))

        customer.purchases = ArrayList()
        repository.save(customer)
        return Response.ok(message("message.user-registered"))
    }

}
