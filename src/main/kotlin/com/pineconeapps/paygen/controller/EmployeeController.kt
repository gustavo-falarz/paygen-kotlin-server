package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.Employee
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.EmployeeSession
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("employee")
class EmployeeController(val session: EmployeeSession) {

    @PutMapping
    fun createEmployee(@RequestBody employee: Employee): Response {
        return session.createEmployee(employee)
    }

}
