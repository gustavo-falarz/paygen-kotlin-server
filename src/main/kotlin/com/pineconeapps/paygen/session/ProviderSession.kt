package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.ImagesDTO

interface ProviderSession {

    fun findProviderByEmail(email: String): Provider

    fun addProvider(provider: Provider): Response

    fun listEmployees(providerId: String): List<Employee>

    fun findAll(): List<Provider>

    fun getImages(providerId: String): ImagesDTO

    fun setImages(providerId: String, dto: ImagesDTO): Response

    fun filter(latitude: String, longitude: String): List<Provider>

}