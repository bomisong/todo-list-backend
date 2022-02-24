package com.scnu.todo.web.rest

import com.scnu.todo.domain.Todo
import com.scnu.todo.repository.TodoRepository
import com.scnu.todo.service.dto.TodoDTO
import com.scnu.todo.service.mapper.TodoMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TodoResource(
    private val todoRepository: TodoRepository,
    private val todoMapper: TodoMapper,
) {

    @PostMapping("/todos")
    fun createTodo(@Valid @RequestBody todoDTO: TodoDTO): Mono<Todo> {
        return todoRepository.save(todoMapper.toEntity(todoDTO))
    }

    @PutMapping("/todos")
    fun updateTodo(@Valid @RequestBody todoDTO: TodoDTO): Mono<Todo> {
        return todoRepository.save(todoMapper.toEntity(todoDTO))
    }

    @GetMapping("/todos")
    fun getAllTodos(): Flux<TodoDTO> {
        return todoRepository.findAll().map(todoMapper::toDto)
    }

    @DeleteMapping("/todos/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun deleteTodo(@PathVariable id: String): Mono<Void> {
        return todoRepository.deleteById(id)
    }
}
