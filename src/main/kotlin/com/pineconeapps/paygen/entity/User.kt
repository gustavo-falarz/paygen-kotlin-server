package com.pineconeapps.paygen.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
open class User(@Id var id: String, var name: String, var email: String, var status: Status) {
    enum class Status {
        ACTIVE, PENDING
    }
}