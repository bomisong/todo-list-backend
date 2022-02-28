package com.scnu.todo.service

import com.scnu.todo.domain.Todo
import com.scnu.todo.repository.TodoRepository
import com.scnu.todo.service.dto.TodoDTO
import com.scnu.todo.service.mapper.TodoMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TodoService(
    private val todoRepository: TodoRepository,
    private val todoMapper: TodoMapper,
) {
    fun createTodo(todoDTO: TodoDTO): Mono<Todo> {
        return todoRepository.save(todoMapper.toEntity(todoDTO))
    }

    fun updateTodo(todoDTO: TodoDTO): Mono<Todo> {
        return todoRepository.save(todoMapper.toEntity(todoDTO))
    }

    fun getAllTodos(): Flux<TodoDTO> {
        return todoRepository.findAll().map(todoMapper::toDto)
    }

    fun deleteTodo(id: String): Mono<Void> {
        return todoRepository.deleteById(id)
    }
}
