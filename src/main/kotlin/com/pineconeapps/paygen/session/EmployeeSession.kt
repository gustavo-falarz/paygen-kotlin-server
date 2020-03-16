package com.pineconeapps.paygen.session

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Response

interface EmployeeSession {

    fun findEmployeeByEmail(email: String): Employee

    fun createEmployee(employee: Employee): Response
}
