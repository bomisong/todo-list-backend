package com.scnu.todo.service.dto

import com.scnu.todo.domain.User

/**
 * A DTO representing a user, with only the public attributes.
 */
open class UserDTO(
    var id: String? = null,
    var login: String? = null,
) {

    constructor(user: User) : this(user.id, user.login)

    override fun toString() = "UserDTO{" +
        "login='" + login + '\'' +
        "}"
}
