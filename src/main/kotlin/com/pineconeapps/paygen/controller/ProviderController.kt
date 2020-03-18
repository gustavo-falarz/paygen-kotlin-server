package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.ImagesDTO
import com.pineconeapps.paygen.session.ProviderSession
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("provider")
class ProviderController(val providerSession: ProviderSession) {

    @PutMapping
    fun createProvider(@RequestBody provider: Provider): Response {
        return providerSession.createProvider(provider)
    }

    @GetMapping("{latitude}/{longitude}")
    fun findProvidersByLocation(@PathVariable latitude: String, @PathVariable longitude: String): List<Provider> {
        return providerSession.findProvidersByLocation(latitude = latitude, longitude = longitude)
    }

    @GetMapping("{id}")
    fun findProviderById(@PathVariable id: String): Provider {
        return providerSession.findProviderById(id)
    }

    @GetMapping("employees/{providerId}")
    fun listEmployees(@PathVariable("providerId") providerId: String): List<Employee> {
        return providerSession.listEmployees(providerId)
    }

    @GetMapping("images/{providerId}")
    fun getImages(@PathVariable("providerId") providerId: String): ImagesDTO {
        return providerSession.getImages(providerId)
    }

    @PostMapping("images/{providerId}")
    fun setImages(@PathVariable("providerId") providerId: String, @RequestBody dto: ImagesDTO): Response {
        return providerSession.setImages(providerId, dto)
    }
}
