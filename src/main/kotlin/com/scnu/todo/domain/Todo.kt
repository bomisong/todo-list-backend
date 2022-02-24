package com.scnu.todo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "todos")
class Todo(

    @Id
    var id: String? = null,

    @Field("taskName")
    var taskName: String? = null,

    @Field("deadline")
    var deadline: Int? = null,
)
