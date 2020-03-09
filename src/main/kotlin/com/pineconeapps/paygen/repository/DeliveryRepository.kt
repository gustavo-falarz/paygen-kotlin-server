package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Delivery
import org.springframework.data.mongodb.repository.MongoRepository

interface DeliveryRepository : MongoRepository<Delivery, String>