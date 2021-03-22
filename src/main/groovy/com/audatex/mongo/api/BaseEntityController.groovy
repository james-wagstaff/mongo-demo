package com.audatex.mongo.api

import com.audatex.mongo.api.entities.BaseEntity
import com.audatex.mongo.api.entities.ChildEntityOne
import com.audatex.mongo.api.entities.ChildEntityTwo
import com.audatex.mongo.api.repositories.BaseEntityRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class BaseEntityController {

    @Autowired
    BaseEntityRepository baseEntityRepository

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/{clazz}")
    Collection<BaseEntity> getAllBaseEntitiesOfType(@PathVariable String clazz) {
        return baseEntityRepository.findAllByClass(clazz)
    }


    /*
    Because BaseEntity is an abstract class, jackson doesn't know how to deserializa the received object,
    so we have to do it manually, we can receive the class name and do a bit of reflection to create the class
    * */
    @PostMapping("/{entityType}")
    BaseEntity getAllBaseEntitiesOfType(@PathVariable String entityType, @RequestBody String baseEntity) {
        Class<?> cls = Class.forName("com.audatex.mongo.api.entities.$entityType");
        BaseEntity parsedBaseEntity = objectMapper.readValue(baseEntity, cls) as BaseEntity
        return baseEntityRepository.save(parsedBaseEntity)
    }

}
