package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.controller.BaseSession
import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Provider
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.entity.dto.ImagesDTO
import com.pineconeapps.paygen.repository.ProviderRepository
import com.pineconeapps.paygen.session.ProviderSession
import com.pineconeapps.paygen.utils.Constants
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Metrics
import org.springframework.data.geo.Point
import org.springframework.stereotype.Component

@Component
class ProviderSession(val repository: ProviderRepository) : BaseSession(), ProviderSession {
    override fun createProvider(provider: Provider): Response {
        val existingProvider = repository.findByEmail(provider.email)
        existingProvider.throwIfDuplicate(error("error.provider-registered"))
        repository.save(provider)
        return Response.ok(message("message.provider-registered"))
    }

    override fun findProvidersByLocation(latitude: String, longitude: String): List<Provider> {
        val point = Point(latitude.toDouble(), longitude.toDouble())
        val distance = Distance(Constants.PROVIDER_RANGE, Metrics.KILOMETERS)
        return repository.findByLocationNearOrderByLocation(point, distance)
    }

    override fun findAll(): List<Provider> = repository.findAll()

    override fun findProviderById(id: String): Provider {
        val provider = repository.findById(id)
        provider.throwIfNull(error("error.provider-not-found"))
        return provider.get()
    }

    override fun findProviderByEmail(email: String): Provider {
        val provider = repository.findByEmail(email)
        provider.throwIfNull(error("error.provider-not-found"))
        return provider.get()
    }

    override fun listEmployees(providerId: String): MutableList<Employee> {
        val provider = findProviderById(providerId)
        return provider.employees
    }

    override fun getImages(providerId: String): ImagesDTO {
        val provider = findProviderById(providerId)
        val info = provider.info

        val imagesDTO = ImagesDTO()
        if (info != null) {
            imagesDTO.banner = info.banner
            imagesDTO.logo = info.logo
        }
        return imagesDTO
    }

    override fun setImages(providerId: String, dto: ImagesDTO): Response {
        val provider = findProviderById(providerId)
        val info = provider.info
        if (info != null) {
            info.banner = dto.banner
            info.logo = dto.logo
        }

        repository.save(provider)
        return Response.ok("message.images-updated")
    }


}
