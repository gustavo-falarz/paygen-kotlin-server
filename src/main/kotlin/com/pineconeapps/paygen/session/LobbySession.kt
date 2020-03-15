package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Lobby
import com.pineconeapps.paygen.entity.Response

interface LobbySession {

    fun checkIn(userID: String, providerId: String): Response

    fun checkOut(userID: String, providerId: String): Response

    fun getLobby(providerId: String): Lobby

    fun getCustomers(providerId: String): List<Customer>

}