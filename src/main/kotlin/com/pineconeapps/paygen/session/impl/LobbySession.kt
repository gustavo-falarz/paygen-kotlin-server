package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.controller.BaseSession
import com.pineconeapps.paygen.entity.*
import com.pineconeapps.paygen.session.CustomerSession
import com.pineconeapps.paygen.session.LobbySession
import com.pineconeapps.paygen.session.ConsumptionSession
import com.pineconeapps.paygen.session.ProviderSession
import com.pineconeapps.paygen.utils.PaygenException
import org.springframework.stereotype.Component

@Component
class LobbySession(
        val providerSession: ProviderSession,
        val consumptionSession: ConsumptionSession,
        val customerSession: CustomerSession
) : LobbySession, BaseSession() {

    override fun checkIn(customerId: String, providerId: String): Response {
        val provider = providerSession.findProviderById(providerId)
        val customer = customerSession.findCustomerById(customerId)
        throwIfCustomerOnLobby(customer, provider)

        customer.checkedIn = CheckedIn(provider.id, provider.name, provider.info)
        customerSession.updateCustomer(customer)

        consumptionSession.addConsumption(customer, provider)

        provider.lobby.customerList.add(customer)
        providerSession.updateProvider(provider)

        return Response.ok(message("message-checkin-success"))
    }

    override fun checkOut(customerId: String, providerId: String): Response {
        val provider = providerSession.findProviderById(providerId)
        val customer = customerSession.findCustomerById(customerId)
        throwIfCustomerNotOnLobby(customer, provider)

        checkConsumptionPaid(customer, provider)
        customer.checkedIn = null
        customerSession.updateCustomer(customer)

        provider.lobby.customerList.remove(customer)
        val consumption = consumptionSession.getConsumption(customerId, providerId)
        provider.consumptions.remove(consumption)
        providerSession.updateProvider(provider)

        return Response.ok(message("message-checkout-success"))
    }

    override fun getCustomers(providerId: String): List<Customer> {
        val provider = providerSession.findProviderById(providerId)
        return provider.lobby.customerList
    }

    fun throwIfCustomerOnLobby(customer: Customer, provider: Provider) {
        if (provider.lobby.customerList.contains(customer)) {
            throw PaygenException(error("error-customer-already-in-lobby"))
        }
    }

    private fun throwIfCustomerNotOnLobby(customer: Customer, provider: Provider) {
        if (!provider.lobby.customerList.contains(customer)) {
            throw PaygenException(error("error-customer-not-in-lobby"))
        }
    }

    fun checkConsumptionPaid(customer: Customer, provider: Provider) {
        val consumption = provider.consumptions.find { it.customer == customer }
        if (consumption != null && consumption.items.isNotEmpty()) {
            throw PaygenException(error("error-consumption-unpaid"))
        }
    }
}
