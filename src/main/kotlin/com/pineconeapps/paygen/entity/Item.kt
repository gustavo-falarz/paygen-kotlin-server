package com.pineconeapps.paygen.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
open class Item(
        var name: String,
        var description: String,
        var value: Double,
        var price: Double,
        var discount: Double = 0.0,
        var picture: String = ""
) {
    @Id
    var id: String? = null

}
