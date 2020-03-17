package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.CheckedIn
import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.LoginDTO
import com.pineconeapps.paygen.session.CustomerSession
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("customer")
class CustomerController(val session: CustomerSession) {

    @PutMapping
    fun createCustomer(@RequestBody customer: Customer): Response {
        return session.createUser(customer)
    }

    @GetMapping("{customerId}")
    fun findCustomerByCpf(@PathVariable customerId: String): Customer {
        return session.findCustomerById(customerId)
    }

    @GetMapping("reception/{customerId}")
    fun checkReception(@PathVariable customerId: String): CheckedIn? {
        return session.checkReception(customerId)
    }

    @PostMapping("update-profile")
    fun updateProfile(@RequestBody dto: LoginDTO): Customer {
        return session.updateProfile(dto)
    }

}
