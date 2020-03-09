package com.pineconeapps.paygen.entity.dto

import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Item
import com.pineconeapps.paygen.entity.Provider

class ConsumptionDTO {
    var customer: Customer? = null
    var provider: Provider? = null
    var items: List<Item>? = null

}