package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.controller.BaseSession
import com.pineconeapps.paygen.entity.Consumption
import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.repository.ConsumptionRepository
import com.pineconeapps.paygen.session.ConsumptionSession
import com.pineconeapps.paygen.session.CustomerSession
import com.pineconeapps.paygen.session.ProviderSession
import com.pineconeapps.paygen.utils.PaygenException
import org.springframework.stereotype.Component

@Component
class ConsumptionSession(
        val repository: ConsumptionRepository,
        val providerSession: ProviderSession,
        val customerSession: CustomerSession
) : ConsumptionSession, BaseSession() {

    override fun addConsumption(customer: Customer, provider: Provider): Response {
        val consumption = Consumption(customer, ArrayList())
        provider.consumptions.add(consumption)
        providerSession.updateProvider(provider)
        return Response.ok(message("message.consumption-added"))
    }

    override fun getConsumption(customerId: String, providerId: String): Consumption {
        val provider = providerSession.findProviderById(providerId)
        val consumption = provider.consumptions.find { it.customer.id == customerId }
        if (consumption == null) {
            throw PaygenException(error("error.consumption-not-found"))
        } else {
            return consumption
        }
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
