package com.audatex.mongo.api.repositories

import com.audatex.mongo.api.entities.BaseEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BaseEntityRepository extends MongoRepository<BaseEntity, String> {

    /*
    If we use findAll(), we will get all of the classes, which we don't really want.
    I couldn't get this system to work with inheritance without the need for multiple repositories,
    So everything will have to go inside of the same collection
    * */
    @Query(value="{ '_class' : ?0 }")
    Collection<BaseEntity> findAllByClass(String clazz)
}
