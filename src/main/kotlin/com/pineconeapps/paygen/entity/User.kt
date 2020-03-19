package com.pineconeapps.paygen.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
open class User(@Id var id: String, var name: String, var email: String, var status: Status) {

    enum class Status {
        ACTIVE, PENDING
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}
