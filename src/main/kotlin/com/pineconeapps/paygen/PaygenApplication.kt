package com.pineconeapps.paygen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaygenApplication

fun main(args: Array<String>) {
    runApplication<PaygenApplication>(*args)
}
