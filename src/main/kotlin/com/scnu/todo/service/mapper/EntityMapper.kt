package com.scnu.todo.service.mapper

interface EntityMapper<D, E> {
    fun toEntity(dto: D): E

    fun toDto(entity: E): D
}
