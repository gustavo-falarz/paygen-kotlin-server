package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Consumption
import org.springframework.data.mongodb.repository.MongoRepository

interface ConsumptionRepository: MongoRepository<Consumption, String> {
}
