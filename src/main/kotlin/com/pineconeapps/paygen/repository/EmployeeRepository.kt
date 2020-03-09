package com.pineconeapps.paygen.repository

import com.pineconeapps.paygen.entity.Employee
import org.springframework.data.mongodb.repository.MongoRepository

interface EmployeeRepository : MongoRepository<Employee, String> {
    fun findByEmail(email: String): Employee
}