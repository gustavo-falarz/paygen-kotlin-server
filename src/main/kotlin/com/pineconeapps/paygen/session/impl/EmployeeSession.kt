package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.controller.BaseSession
import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.repository.EmployeeRepository
import com.pineconeapps.paygen.session.EmployeeSession
import com.pineconeapps.paygen.utils.PaygenException
import org.springframework.stereotype.Component

@Component
class EmployeeSession(val employeeRepository: EmployeeRepository,
                      val providerSession: ProviderSession) : EmployeeSession, BaseSession() {
    override fun findEmployeeByEmail(email: String): Employee {
        val existingEmployee = employeeRepository.findByEmail(email)
        existingEmployee.throwIfNull(error("error.employee-not-found"))
        return existingEmployee.get()
    }

    override fun createEmployee(employee: Employee, providerId: String): Response {
        val provider = providerSession.findProviderById(providerId)
        val employees = provider.employees
        val existingEmployee = employees.find { it.email == employee.email }
        if (existingEmployee != null){
            throw PaygenException(error("error.employee-already-exists"))
        }

        employees.add(employee)
        providerSession.updateProvider(provider)

        return Response.ok(message("message.employee-created"))
    }
}
