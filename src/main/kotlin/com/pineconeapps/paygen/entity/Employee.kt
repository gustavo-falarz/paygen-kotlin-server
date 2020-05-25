package com.pineconeapps.paygen.entity

class Employee(id: String, name: String, email: String, status: Status) : User(id, name, email, status) {
    var role: Role? = null

    enum class Role {
        MANAGER, CASHIER, WAITER, ATTENDANT
    }
}