package com.audatex.mongo.api.entities

import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@Document
@TypeAlias("ChildEntityTwo")
/*
We can use @TypeAlias to avoid saving the package name with the class in the database
* */
class ChildEntityTwo extends BaseEntity {

    String somePropertyExtra

}
