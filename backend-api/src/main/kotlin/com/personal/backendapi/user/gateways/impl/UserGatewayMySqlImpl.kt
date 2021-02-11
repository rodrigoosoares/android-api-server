package com.personal.backendapi.user.gateways.impl

import com.personal.backendapi.user.gateways.UserGateway
import com.personal.backendapi.user.gateways.entities.User
import com.personal.backendapi.user.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserGatewayMySqlImpl (
    val userRepository: UserRepository
) : UserGateway {

    override fun getAllUsers(): List<User> {
        try {
            return userRepository.getAllUsers()
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }
}