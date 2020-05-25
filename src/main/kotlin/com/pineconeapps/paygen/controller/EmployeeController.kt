package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.EmployeeSession
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("employee")
class EmployeeController(val session: EmployeeSession) {

    @PutMapping ("{provider-id}")
    fun createEmployee(@RequestBody employee: Employee,
                       @PathVariable("provider-id") providerId: String): Response {
        return session.createEmployee(employee, providerId)
    }

}
