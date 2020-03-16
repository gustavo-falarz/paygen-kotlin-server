package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.Consumption
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.ConsumptionSession
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("consumption")
class ConsumptionController(val session: ConsumptionSession) {

    @GetMapping("{userId}/{providerId}")
    fun getConsumption(
            @PathVariable("userId") userId: String,
            @PathVariable("providerId") providerId: String
    ): Consumption {
        return session.getConsumption(userId, providerId)
    }

    @PutMapping("{providerId}/{customerId}/{itemId}")
    fun additem(@PathVariable("itemId") itemId: String,
                @PathVariable("providerId") providerId: String,
                @PathVariable("customerId") customerId: String): Response {
        return session.addItem(providerId, customerId, itemId)
    }

    @DeleteMapping("{providerId}/{customerId}/{itemId}")
    fun removeItem(@PathVariable("providerId") providerId: String,
                   @PathVariable("customerId") customerId: String,
                   @PathVariable("itemId") itemId: String): Response {
        return session.removeItem(providerId, customerId, itemId)
    }

}
