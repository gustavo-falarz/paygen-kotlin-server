package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping
interface UserRepository : MongoRepository<User, String> {
    fun findByEmail(email: String): User
}