package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.entity.Delivery
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.Transaction
import com.pineconeapps.paygen.entity.dto.DateFilter
import org.springframework.stereotype.Component
import com.pineconeapps.paygen.session.TransactionSession

@Component
class TransactionSession : TransactionSession {
    override fun add(transaction: Transaction): Response {
        TODO("not implemented")
    }

    override fun findTransaction(transactionId: String): Transaction {
        TODO("not implemented")
    }

    override fun geTransactions(providerId: String): List<Transaction> {
        TODO("not implemented")
    }

    override fun addDelivery(delivery: Delivery): Response {
        TODO("not implemented")
    }

    override fun updateDelivery(delivery: Delivery): Response {
        TODO("not implemented")
    }

    override fun getCustomerTransactions(customerId: String): List<Transaction> {
        TODO("not implemented")
    }

    override fun filterSales(providerId: String, dateFilter: DateFilter): List<Transaction> {
        TODO("not implemented")
    }

    override fun filterPurchases(userId: String, dateFilter: DateFilter): List<Transaction> {
        TODO("not implemented")
    }


}
