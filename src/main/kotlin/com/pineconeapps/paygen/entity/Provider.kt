package com.pineconeapps.paygen.entity

import org.springframework.context.annotation.Lazy
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.mapping.DBRef


class Provider(
        id: String,
        name: String,
        email: String,
        status: Status = Status.PENDING
) : User(id, name, email, status) {
    var lobby: Lobby = Lobby()

    @DBRef
    @Lazy
    var sales: MutableList<Transaction> = ArrayList()

    @DBRef
    @Lazy
    var consumptions: MutableList<Consumption> = ArrayList()

    @DBRef
    @Lazy
    var employees: MutableList<Employee> = ArrayList()

    @DBRef
    @Lazy
    var products: MutableList<Product> = ArrayList()

    @DBRef
    @Lazy
    var services: MutableList<Service> = ArrayList()

    var location: Point? = null

    var info: ProviderInfo? = null

}
