package com.personal.backendapi.user.adapters

import com.personal.backendapi.user.controllers.entities.UserResponse
import com.personal.backendapi.user.gateways.entities.User
import kotlin.streams.toList

class UserResponseAdapter private constructor() {

    companion object {

        fun fromUsers(users: List<User>) = users.stream().map(::fromUser).toList()

        private fun fromUser(user: User) : UserResponse {
            return UserResponse.builder()
                .email(user.email)
                .name(user.name)
                .build()
        }

    }

}