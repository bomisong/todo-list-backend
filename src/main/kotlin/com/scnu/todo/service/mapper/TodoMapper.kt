package com.scnu.todo.service.mapper

import com.scnu.todo.domain.Todo
import com.scnu.todo.service.dto.TodoDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", uses = [], unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TodoMapper : EntityMapper<TodoDTO, Todo>
