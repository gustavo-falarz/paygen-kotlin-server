package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.dto.LoginDTO
import com.pineconeapps.paygen.session.CustomerSession
import org.springframework.stereotype.Component

@Component
class CustomerSession: CustomerSession {
    override fun findCustomerByCpf(cpf: String): Customer {
        TODO("Not yet implemented")
    }

    override fun updateCustomer(customer: Customer): Customer {
        TODO("Not yet implemented")
    }

    override fun checkReception(customerId: String): Customer {
        TODO("Not yet implemented")
    }

    override fun updateProfile(dto: LoginDTO): Customer {
        TODO("Not yet implemented")
    }

    override fun createUser(customer: Customer): Customer {
        TODO("Not yet implemented")
    }

}
