package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Lobby
import com.pineconeapps.paygen.entity.Response
import org.springframework.stereotype.Component

interface LobbySession {

    fun checkIn(userID: String, providerId: String): Response

    fun checkOut(userID: String, providerId: String): Response

    fun getLobby(providerId: String): Lobby

}