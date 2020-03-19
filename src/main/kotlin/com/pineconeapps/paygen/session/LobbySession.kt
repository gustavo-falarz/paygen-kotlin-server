package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Lobby
import com.pineconeapps.paygen.entity.Response

interface LobbySession {

    fun checkIn(customerId: String, providerId: String): Response

    fun checkOut(customerId: String, providerId: String): Response

    fun getCustomers(providerId: String): List<Customer>

}
