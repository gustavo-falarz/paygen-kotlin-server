package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Lobby
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.LobbySession
import org.springframework.stereotype.Component

@Component
class LobbySession: LobbySession {
    override fun checkIn(userID: String, providerId: String): Response {
        TODO("Not yet implemented")
    }

    override fun checkOut(userID: String, providerId: String): Response {
        TODO("Not yet implemented")
    }

    override fun getLobby(providerId: String): Lobby {
        TODO("Not yet implemented")
    }

    override fun getCustomers(providerId: String): List<Customer> {
        TODO("Not yet implemented")
    }
}
