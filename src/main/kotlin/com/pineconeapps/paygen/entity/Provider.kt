package com.pineconeapps.paygen.entity

import org.springframework.context.annotation.Lazy
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.mapping.DBRef


class Provider(id: String, name: String, email: String, status: Status) : User(id, name, email, status) {
    var lobby: Lobby? = null

    @DBRef
    @Lazy
    var sales: List<Transaction>? = null

    @Lazy
    var consumptions: MutableList<Consumption>? = null

    @DBRef
    @Lazy
    var employees: List<User>? = null

    @DBRef
    @Lazy
    var items: List<Item>? = null
    var location: Point? = null
    var info: ProviderInfo? = null

}