package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.CheckedIn
import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.LoginDTO
import com.pineconeapps.paygen.session.CustomerSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("customer")
class CustomerController @Autowired constructor(private val session: CustomerSession) {

    @PutMapping
    fun createCustomer(customer: Customer): Response {
        return session.createUser(customer)
    }

    @GetMapping("{cpf}")
    fun findCustomerByCpf(@PathVariable cpf: String): Customer {
        return session.findCustomerByCpf(cpf)
    }

    @GetMapping("reception/{customerId}")
    fun checkReception(@PathVariable customerId: String): CheckedIn? {
        return session.checkReception(customerId)
    }

    @PostMapping("updateProfile")
    fun updateProfile(@RequestBody dto: LoginDTO): Customer {
        return session.updateProfile(dto)
    }

}
