package com.pineconeapps.paygen.entity

class ProviderInfo {
    var address: String? = null
    var about: String = ""
    var type: Type? = null
    var banner: String = ""
    var logo: String = ""

    var openHours: List<OpenHours>? = null


    enum class Type {
        RESTAURANT, HAMBURGUER, PIZZA
    }
}
