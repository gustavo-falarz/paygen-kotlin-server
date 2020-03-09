package com.pineconeapps.paygen.entity

class ProviderInfo {
    var address: String? = null
    var about: String? = null
    var type: Type? = null
    var banner: String? = null
    var logo: String? = null

    var openHours: List<OpenHours>? = null

    enum class Type {
        RESTAURANT, HAMBURGUER, PIZZA
    }
}