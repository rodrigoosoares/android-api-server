package com.personal.backendapi.user.controllers

import com.personal.backendapi.user.adapters.UserResponseAdapter
import com.personal.backendapi.user.controllers.entities.UserResponse
import com.personal.backendapi.user.gateways.entities.User
import com.personal.backendapi.user.usecases.GetUsers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
    val getUsers: GetUsers
) {

    @GetMapping("/all")
    fun getUsers(): List<UserResponse> {
        val users: List<User> = getUsers.execute()

        return UserResponseAdapter.fromUsers(users)
    }

}