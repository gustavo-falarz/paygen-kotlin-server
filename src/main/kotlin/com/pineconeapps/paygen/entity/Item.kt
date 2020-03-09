package com.pineconeapps.paygen.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
open class Item {
    @Id
    var id: String? = null
    var name: String? = null
    var description: String? = null
    var value = 0.0
    var price = 0.0
    var discount = 0.0
    var picture: String? = null

}