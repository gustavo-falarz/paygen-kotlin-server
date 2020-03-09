package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Delivery
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.Transaction
import com.pineconeapps.paygen.entity.dto.DateFilter

interface TransactionSession {

    fun add(transaction: Transaction): Response

    fun findTransaction(transactionId: String): Transaction

    fun geTransactions(providerId: String): List<Transaction>

    fun addDelivery(delivery: Delivery): Response

    fun updateDelivery(delivery: Delivery): Response

    fun getCustomerTransactions(customerId: String): Response

    fun filterSales(providerId: String, dateFilter: DateFilter): List<Transaction>

    fun filterPurchases(userId: String, dateFilter: DateFilter): List<Transaction>

}