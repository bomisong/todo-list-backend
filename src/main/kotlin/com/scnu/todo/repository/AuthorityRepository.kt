package com.scnu.todo.repository

import com.scnu.todo.domain.Authority
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * Spring Data MongoDB repository for the [Authority] entity.
 */

interface AuthorityRepository : ReactiveMongoRepository<Authority, String>
