package com.audatex.mongo

import com.audatex.mongo.api.entities.BaseEntity
import com.audatex.mongo.api.entities.ChildEntityOne
import com.audatex.mongo.api.entities.ChildEntityTwo
import com.audatex.mongo.api.repositories.BaseEntityRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@Slf4j
@SpringBootApplication
class MongoApplication {

    static void main(String[] args) {
        SpringApplication.run(MongoApplication, args)
    }

    @Autowired
    BaseEntityRepository derivedEntityOneRepository

    /*
    Let's put in some dummy data, there is also an api for manually inserting data
    * */
    @Bean
    void instantiateData() {
        BaseEntity childEntityOne = new ChildEntityOne()
        childEntityOne.id = "test1"
        childEntityOne.propertyOne = "prop1"
        childEntityOne.propertyTwo = "prop2"
        childEntityOne.propertyThree = "prop3"
        childEntityOne.anotherProperty = "another property"
        childEntityOne.anotherPropertyTwo = "another property 2"
        childEntityOne.anotherPropertyThree = "another property 3"
        derivedEntityOneRepository.save(childEntityOne)

        BaseEntity childEntityTwo = new ChildEntityTwo()
        childEntityTwo.id = "test2"
        childEntityTwo.propertyOne = "prop1"
        childEntityTwo.propertyTwo = "prop2"
        childEntityTwo.propertyThree = "prop3"
        childEntityTwo.somePropertyExtra = "an extra property"
        derivedEntityOneRepository.save(childEntityTwo)
    }
}
