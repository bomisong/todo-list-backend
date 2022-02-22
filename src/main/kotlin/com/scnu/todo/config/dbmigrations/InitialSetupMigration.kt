package com.scnu.todo.config.dbmigrations

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate
import com.scnu.todo.config.SYSTEM_ACCOUNT
import com.scnu.todo.domain.Authority
import com.scnu.todo.domain.User
import com.scnu.todo.security.ADMIN
import com.scnu.todo.security.USER
import java.time.Instant

/**
 * Creates the initial database setup.
 */
@ChangeLog(order = "001")
@Suppress("unused")
class InitialSetupMigration {

    @ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
    fun addAuthorities(mongoTemplate: MongockTemplate) {
        val adminAuthority = Authority(ADMIN)
        val userAuthority = Authority(USER)

        mongoTemplate.save(adminAuthority)
        mongoTemplate.save(userAuthority)
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    fun addUsers(mongoTemplate: MongockTemplate) {
        val adminAuthority = Authority(ADMIN)
        val userAuthority = Authority(USER)

        val adminUser = User(
            id = "user-1",
            login = "admin",
            password = "\$2a\$10\$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC",
            firstName = "admin",
            lastName = "Administrator",
            email = "admin@localhost",
            activated = true,
            langKey = "en",
            createdBy = SYSTEM_ACCOUNT,
            createdDate = Instant.now(),
            authorities = mutableSetOf(adminAuthority, userAuthority)
        )
        mongoTemplate.save(adminUser)

        val userUser = User(
            id = "user-2",
            login = "user",
            password = "\$2a\$10\$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K",
            firstName = "",
            lastName = "User",
            email = "user@localhost",
            activated = true,
            langKey = "en",
            createdBy = SYSTEM_ACCOUNT,
            createdDate = Instant.now(),
            authorities = mutableSetOf(userAuthority)
        )
        mongoTemplate.save(userUser)
    }
}
