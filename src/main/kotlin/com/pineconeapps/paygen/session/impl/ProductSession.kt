package com.pineconeapps.paygen.session.impl

import com.pineconeapps.paygen.controller.BaseSession
import com.pineconeapps.paygen.entity.Product
import com.pineconeapps.paygen.entity.Response
import com.pineconeapps.paygen.repository.ProductRepository
import com.pineconeapps.paygen.repository.ProviderRepository
import com.pineconeapps.paygen.session.ProductSession
import com.pineconeapps.paygen.utils.PaygenException
import org.springframework.stereotype.Component

@Component
class ProductSession(
        val productRepository: ProductRepository,
        val providerRepository: ProviderRepository,
        val providerSession: ProviderSession
) : BaseSession(), ProductSession {

    override fun listProducts(providerId: String): List<Product> {
        val provider = providerSession.findProviderById(providerId)
        return provider.products
    }

    override fun addProduct(providerId: String, product: Product): Response {
        val provider = providerSession.findProviderById(providerId)
        productRepository.save(product)
        provider.products.add(product)
        providerRepository.save(provider)
        return Response.ok(message("message-product-added"))
    }

    override fun findProduct(providerId: String, query: String): Product {
        val provider = providerSession.findProviderById(providerId)
        val products = provider.products
        return products.find { it.description.contains(query.decapitalize()) }
                ?: throw PaygenException(error("error.product-not-found"))
    }

    override fun findProduct(id: String): Product {
        val product = productRepository.findById(id)
        product.throwIfNull(error("error.product-not-found"))
        return product.get()
    }

    override fun findProducts(providerId: String, query: String): List<Product> {
        val provider = providerSession.findProviderById(providerId)
        val products = provider.products
        return products.filter { it.description.decapitalize().contains(query.decapitalize()) ||
                it.name.decapitalize().contains(query.decapitalize()) }
    }

}
