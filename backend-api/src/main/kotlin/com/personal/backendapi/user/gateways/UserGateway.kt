package com.personal.backendapi.user.gateways

import com.personal.backendapi.user.gateways.entities.User

interface UserGateway {

    fun getAllUsers() : List<User>
}