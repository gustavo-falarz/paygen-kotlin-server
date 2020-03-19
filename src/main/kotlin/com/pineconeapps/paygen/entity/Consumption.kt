package com.pineconeapps.paygen.entity

import org.springframework.data.mongodb.core.mapping.DBRef

class Consumption(@DBRef var customer: Customer, var items: MutableList<Item>) {
    var id: String? = null

}
