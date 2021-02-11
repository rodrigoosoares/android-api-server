package com.personal.backendapi.user.usecases

import com.personal.backendapi.user.gateways.UserGateway
import com.personal.backendapi.user.gateways.entities.User
import org.springframework.stereotype.Component

@Component
class GetUsers (
    val userGateway: UserGateway
        ) {

    fun execute() : List<User> = userGateway.getAllUsers()

}