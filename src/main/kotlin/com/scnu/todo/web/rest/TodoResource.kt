package com.scnu.todo.web.rest

import com.scnu.todo.domain.Todo
import com.scnu.todo.service.TodoService
import com.scnu.todo.service.dto.TodoDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TodoResource(
    private val todoService: TodoService,
) {

    @PostMapping("/todos")
    fun createTodo(@Valid @RequestBody todoDTO: TodoDTO): Mono<Todo> {
        return todoService.createTodo(todoDTO)
    }

    @PutMapping("/todos")
    fun updateTodo(@Valid @RequestBody todoDTO: TodoDTO): Mono<Todo> {
        return todoService.updateTodo(todoDTO)
    }

    @GetMapping("/todos")
    fun getAllTodos(): Flux<TodoDTO> {
        return todoService.getAllTodos()
    }

    @DeleteMapping("/todos/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun deleteTodo(@PathVariable id: String): Mono<Void> {
        return todoService.deleteTodo(id)
    }
}
