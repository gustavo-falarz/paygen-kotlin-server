package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.ImagesDTO

interface ProviderSession {

    fun createProvider(provider: Provider): Response

    fun findProvidersByLocation(latitude: String, longitude: String): List<Provider>

    fun findAll(): List<Provider>

    fun findProviderById(id: String): Provider

    fun findProviderByEmail(email: String): Provider

    fun listEmployees(providerId: String): List<Employee>

    fun getImages(providerId: String): ImagesDTO

    fun setImages(providerId: String, dto: ImagesDTO): Response

    fun updateProvider(provider: Provider)

}
