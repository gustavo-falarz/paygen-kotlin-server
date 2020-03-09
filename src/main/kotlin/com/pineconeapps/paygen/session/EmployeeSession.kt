package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Response
import org.springframework.stereotype.Component

interface EmployeeSession {

    fun findEmployeeByEmail(email: String): Employee

    fun createEmployee(employee: Employee): Response
}