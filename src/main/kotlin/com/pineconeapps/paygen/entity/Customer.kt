package com.pineconeapps.paygen.entity

import org.springframework.context.annotation.Lazy
import org.springframework.data.mongodb.core.mapping.DBRef

class Customer(
        id: String,
        name: String,
        email: String,
        status: Status = Status.ACTIVE,
        var picture: String = "",
        @DBRef @field:Lazy var purchases: MutableList<Transaction> = ArrayList()
) : User(id, name, email, status) {

    var checkedIn: CheckedIn? = null

}
