package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.EmployeeSession
import org.springframework.stereotype.Component

@Component
class EmployeeSession : EmployeeSession{
    override fun findEmployeeByEmail(email: String): Employee {
        TODO("not implemented")
    }

    override fun createEmployee(employee: Employee): Response {
        TODO("not implemented")
    }
}
