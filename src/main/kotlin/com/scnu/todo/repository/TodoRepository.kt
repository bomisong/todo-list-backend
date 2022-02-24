package com.scnu.todo.repository

import com.scnu.todo.domain.Todo
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : ReactiveMongoRepository<Todo, String>
