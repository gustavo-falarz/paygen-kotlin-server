@file:Suppress("SpringDataRepositoryMethodParametersInspection")

package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Provider
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProviderRepository : MongoRepository<Provider, String> {

    fun findByEmail(email: String): Optional<Provider>

    fun findByLocationNearOrderByLocation(location: Point, distance: Distance): List<Provider>
}
