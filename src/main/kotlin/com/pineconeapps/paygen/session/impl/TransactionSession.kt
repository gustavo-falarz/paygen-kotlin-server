package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.controller.BaseSession
import com.pineconeapps.paygen.entity.Delivery
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.Transaction
import com.pineconeapps.paygen.entity.dto.DateFilter
import com.pineconeapps.paygen.repository.TransactionRepository
import com.pineconeapps.paygen.session.TransactionSession
import com.pineconeapps.paygen.utils.PaygenException
import org.springframework.stereotype.Component

@Component
class TransactionSession(
        val customerSession: CustomerSession,
        val providerSession: ProviderSession,
        val transactionRepository: TransactionRepository,
        val consumptionSession: ConsumptionSession,
        val lobbySession: LobbySession
) : TransactionSession, BaseSession() {

    override fun add(transaction: Transaction): Response {
        val customer = customerSession.findCustomerById(transaction.customerId)
        val provider = providerSession.findProviderById(transaction.providerId)

        val savedTransaction = transactionRepository.save(transaction)

        customer.purchases.add(savedTransaction)
        customerSession.updateCustomer(customer)

        provider.sales.add(savedTransaction)
        providerSession.updateProvider(provider)

        consumptionSession.removeConsumption(customer.id, provider.id)

        lobbySession.checkOut(customer.id, provider.id)

        return Response.ok(message("message.transaction-registered"))
    }

    override fun findTransaction(transactionId: String): Transaction {
        val transaction = transactionRepository.findById(transactionId)
        transaction.throwIfNull("error.transaction-not-found")
        return transaction.get()
    }

    override fun geTransactions(providerId: String): List<Transaction> {
        return transactionRepository.findTop100ByProviderIdOrderByDateDesc(providerId)
    }

    override fun addDelivery(delivery: Delivery): Response {
        val provider = providerSession.findProviderById(delivery.providerId)
        val customer = customerSession.findCustomerById(delivery.customerId)

        val savedDelivery = transactionRepository.save(delivery)

        customer.purchases.add(savedDelivery)
        customerSession.updateCustomer(customer)

        provider.sales.add(savedDelivery)
        providerSession.updateProvider(provider)

        consumptionSession.removeConsumption(customer.id, provider.id)

        lobbySession.checkOut(customer.id, provider.id)

        return Response.ok(message("message.transaction-registered"))
    }

    override fun updateDelivery(delivery: Delivery): Response {
        transactionRepository.save(delivery)
        return Response.ok(message("message.delivery-updated"))
    }

    override fun getCustomerTransactions(customerId: String): List<Transaction> {
        val transactions = transactionRepository.findByCustomerIdOrderByDateDesc(customerId)
        if (transactions.isNullOrEmpty()) {
            throw PaygenException(error("error.transactions-not-found"))
        }
        return transactions;
    }

    override fun filterSales(providerId: String, dateFilter: DateFilter): List<Transaction> {
        val transactions = transactionRepository
                .findByDateBetweenAndProviderIdOrderByDateDesc(dateFilter.startDate!!, dateFilter.endDate!!, providerId);
        if (transactions.isNullOrEmpty()) {
            throw PaygenException(error("error.transactions-not-found"))
        }
        return transactions;
    }

    override fun filterPurchases(userId: String, dateFilter: DateFilter): List<Transaction> {
        val transactions = transactionRepository
                .findByDateBetweenAndCustomerIdOrderByDateDesc(dateFilter.startDate!!, dateFilter.endDate!!, userId);
        if (transactions.isNullOrEmpty()) {
            throw PaygenException(error("error.transactions-not-found"))
        }
        return transactions;
    }

}
