package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.entity.Consumption
import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.ConsumptionSession
import org.springframework.stereotype.Component

@Component
class ConsumptionSession : ConsumptionSession {
    override fun addConsumption(customer: Customer, provider: Provider): Response {
        TODO("not implemented")
    }

    override fun getConsumption(customerId: String, providerId: String): Consumption {
        TODO("not implemented")
    }

    override fun addItem(providerId: String, customerId: String, itemId: String): Response {
        TODO("not implemented")
    }

    override fun removeItem(providerId: String, customerId: String, itemId: String): Response {
        TODO("not implemented")
    }

    override fun removeConsumption(customerId: String, providerId: String): Response {
        TODO("not implemented")
    }

}
