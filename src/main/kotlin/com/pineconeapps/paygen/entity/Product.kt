package com.pineconeapps.paygen.entity

class Product(
        name: String,
        description: String,
        value: Double,
        price: Double
) : Item(name, description, value, value, price)