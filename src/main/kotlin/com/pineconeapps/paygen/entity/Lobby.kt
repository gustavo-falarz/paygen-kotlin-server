package com.pineconeapps.paygen.entity

import org.springframework.data.mongodb.core.mapping.DBRef

class Lobby(@DBRef
            var customerList: List<Customer>) {

}