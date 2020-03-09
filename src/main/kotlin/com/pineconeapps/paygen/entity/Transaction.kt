package com.pineconeapps.paygen.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.repository.cdi.Eager
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

@Eager
open class Transaction {
    @Id
    var id: String? = null
    var items: List<Item>? = null
    var total = 0.0
    var discount = 0.0
    var payment: Payment? = null
    var customerId: String? = null
    var providerId: String? = null

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    var date: Date? = null

    enum class Status {
        PAID, PENDING, CANCELED, OPEN
    }
}