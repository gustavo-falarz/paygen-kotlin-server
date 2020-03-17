package com.pineconeapps.paygen.config

import com.pineconeapps.paygen.entity.Provider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.index.GeospatialIndex
import javax.annotation.PostConstruct

@Configuration
@DependsOn("mongoTemplate")
class CollectionsConfig(@Autowired
                        private val mongoTemplate: MongoTemplate) {

    @PostConstruct
    fun initIndexes() {
        mongoTemplate.indexOps(Provider::class.java).ensureIndex(GeospatialIndex("location"))
    }
}
