package com.pineconeapps.paygen.entity

import org.springframework.data.mongodb.core.mapping.DBRef

class Consumption {
    var id: String? = null

    @DBRef
    var customer: Customer? = null
    var items: MutableList<Item>? = null

}