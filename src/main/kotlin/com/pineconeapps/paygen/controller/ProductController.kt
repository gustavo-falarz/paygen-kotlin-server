package com.pineconeapps.paygen.controller

import com.pineconeapps.paygen.entity.Product
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.session.ProductSession
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(val session: ProductSession) {


    @GetMapping("{providerId}")
    fun getItems(@PathVariable("providerId") providerId: String): List<Product> {
        return session.listProducts(providerId)
    }

    @PutMapping("{providerId}")
    fun addProduct(
            @RequestBody product: Product,
            @PathVariable("providerId") providerId: String
    ): Response {
        return session.addProduct(providerId, product)
    }

    @GetMapping("{providerId}/{query}")
    fun findProduct(
            @PathVariable("providerId") providerId: String,
            @PathVariable("query") query: String
    ): List<Product> {
        return session.findProduct(providerId, query)
    }
}