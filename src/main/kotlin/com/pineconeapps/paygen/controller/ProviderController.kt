package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.session.ProviderSession
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("provider")
class ProviderController(val providerSession: ProviderSession) {


    @GetMapping("{latitude}/{longitude}")
    fun findProvidersByLocation(@PathVariable latitude: String, @PathVariable longitude: String): List<Provider> {
        return providerSession.findProvidersByLocation(latitude = latitude, longitude = longitude)
    }

}
