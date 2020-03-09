package com.pineconeapps.paygen.entity

import org.springframework.context.annotation.Lazy
import org.springframework.data.mongodb.core.mapping.DBRef

class Customer(id: String,
               name: String,
               email: String, 
               status: Status,
               var cpf: String) : User(id, name, email, status) {

    var picture: String? = null

    @DBRef
    @Lazy
    var purchases: List<Transaction>? = null
    var checkedIn: CheckedIn? = null

}