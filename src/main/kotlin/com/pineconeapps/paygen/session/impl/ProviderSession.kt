package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.controller.BaseSession
import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.ImagesDTO
import com.pineconeapps.paygen.repository.ProviderRepository
import com.pineconeapps.paygen.session.ProviderSession
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class ProviderSession(val repository: ProviderRepository) : BaseSession(), ProviderSession {
    override fun findProviderByEmail(email: String): Provider {
        TODO("not implemented")
    }

    override fun addProvider(provider: Provider): Response {
        TODO("not implemented")
    }

    override fun listEmployees(providerId: String): List<Employee> {
        TODO("not implemented")
    }

    override fun findAll(): List<Provider> {
        TODO("not implemented")
    }

    override fun getImages(providerId: String): ImagesDTO {
        TODO("not implemented")
    }

    override fun setImages(providerId: String, dto: ImagesDTO): Response {
        TODO("not implemented")
    }

    override fun findProvidersByLocation(latitude: String, longitude: String): List<Provider> {
        TODO("not implemented")
    }

    override fun findProviderById(id: String): Provider {
        val provider = repository.findById(id)
        provider.exists(error("error.provider-not-found"))
        return provider.get()
    }

}
