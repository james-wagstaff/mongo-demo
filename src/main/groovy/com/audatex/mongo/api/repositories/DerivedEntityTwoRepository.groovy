package com.audatex.mongo.api.repositories

import com.audatex.mongo.api.entities.BaseEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DerivedEntityTwoRepository extends MongoRepository<BaseEntity, String> {
}
