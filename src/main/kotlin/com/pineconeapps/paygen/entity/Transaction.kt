package com.pineconeapps.paygen.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.repository.cdi.Eager
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import kotlin.collections.ArrayList

@Eager
@Document
open class Transaction(
        var items: List<Item> = ArrayList(),
        var total: Double = 0.0,
        var discount: Double = 0.0,
        var payment: Payment,
        var customerId: String,
        var providerId: String,
        @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @field:JsonFormat(pattern = "dd/MM/yyyy")
        var date: Date = Date()
) {
    @Id
    var id: String? = null

    enum class Status {
        PAID, PENDING, CANCELED, OPEN
    }
}
