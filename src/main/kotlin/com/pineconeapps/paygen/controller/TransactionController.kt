package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.Delivery
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.Transaction
import com.pineconeapps.paygen.entity.dto.DateFilter
import com.pineconeapps.paygen.session.TransactionSession
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("transaction")
class TransactionController(val session: TransactionSession) {
    @PutMapping
    fun add(@RequestBody transaction: Transaction): Response {
        return session.add(transaction)
    }

    @GetMapping("provider/{providerId}")
    fun getTransactions(@PathVariable("providerId") providerId: String): List<Transaction> {
        return session.geTransactions(providerId)
    }

    @GetMapping("customer/{customerId}")
    fun getCustomerTransactions(@PathVariable("customerId") providerId: String): List<Transaction> {
        return session.getCustomerTransactions(providerId)
    }

    @GetMapping("{transactionId}")
    fun findTransaction(@PathVariable("transactionId") transactionId: String): Transaction {
        return session.findTransaction(transactionId)
    }

    @GetMapping("sales/{providerId}")
    fun filterSales(@PathVariable("providerId") providerId: String,
                    @RequestBody dateFilter: DateFilter): List<Transaction> {
        return session.filterSales(providerId, dateFilter)
    }

    @GetMapping("purchases/{userId}")
    fun filterPurchases(@PathVariable("userId") providerId: String,
                        @RequestBody dateFilter: DateFilter): List<Transaction> {
        return session.filterPurchases(providerId, dateFilter)
    }

    @PutMapping("delivery")
    fun addDelivery(@RequestBody delivery: Delivery): Response {
        return session.addDelivery(delivery)
    }

    @PostMapping("delivery")
    fun updateDelivery(@RequestBody delivery: Delivery): Response? {
        return session.updateDelivery(delivery)
    }
}
