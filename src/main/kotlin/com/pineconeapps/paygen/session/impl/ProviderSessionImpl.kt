package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.ImagesDTO
import com.pineconeapps.paygen.session.ProviderSession
import org.springframework.stereotype.Component

@Component
class ProviderSessionImpl : ProviderSession{
    override fun findProviderByEmail(email: String): Provider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addProvider(provider: Provider): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listEmployees(providerId: String): List<Employee> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<Provider> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getImages(providerId: String): ImagesDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setImages(providerId: String, dto: ImagesDTO): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findProvidersByLocation(latitude: String, longitude: String): List<Provider> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
