package com.pineconeapps.paygen.entity

class Delivery : Transaction() {
    var statusDelivery: StatusDelivery? = null
    var observation: String? = null

    enum class StatusDelivery {
        DELIVERED, PENDING
    }
}