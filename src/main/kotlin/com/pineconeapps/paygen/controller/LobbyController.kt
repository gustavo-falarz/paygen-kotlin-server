package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.Customer
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.LobbySession
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("lobby")
class LobbyController(val lobbySession: LobbySession) {


    @GetMapping("checkIn/{userId}/{providerId}")
    fun checkin(@PathVariable userId: String, @PathVariable providerId: String): Response {
        return lobbySession.checkIn(userId, providerId)
    }

    @RequestMapping("checkOut/{userId}/{providerId}")
    fun checkout(@PathVariable userId: String, @PathVariable providerId: String): Response {
        return lobbySession.checkOut(userId, providerId)
    }

    @GetMapping("/getCustomer/{providerId}")
    fun getCustomers(@PathVariable providerId: String): List<Customer> {
        return lobbySession.getCustomers(providerId)
    }

}