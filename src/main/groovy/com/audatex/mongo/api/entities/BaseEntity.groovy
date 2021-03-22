package com.audatex.mongo.api.entities;


import groovy.transform.ToString
import org.springframework.data.annotation.Id

@ToString(includePackage = false, includeNames = true)
abstract class BaseEntity {

    @Id
    String id

    String propertyOne
    String propertyTwo
    String propertyThree

}
