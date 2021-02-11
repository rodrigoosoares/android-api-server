package com.personal.backendapi.user.repositories

import com.personal.backendapi.user.gateways.entities.User
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    val jdbcTemplate: JdbcTemplate
) {


    fun getAllUsers(): List<User> {
        val query: String = """
                SELECT
                    name,
                    email
                FROM
                    t_user
            """.trimIndent()
        return jdbcTemplate.query(query, BeanPropertyRowMapper(User::class.java))
    }
}