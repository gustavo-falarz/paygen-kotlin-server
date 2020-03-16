package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Consumption
import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response

interface ConsumptionSession {

    fun addConsumption(customer: Customer, provider: Provider): Response

    fun getConsumption(customerId: String, providerId: String): Consumption

    fun addItem(providerId: String, customerId: String, itemId: String): Response

    fun removeItem(providerId: String, customerId: String, itemId: String): Response

    fun removeConsumption(customerId: String, providerId: String): Response

}
