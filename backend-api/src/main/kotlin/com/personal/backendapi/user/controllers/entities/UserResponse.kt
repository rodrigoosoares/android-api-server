package com.personal.backendapi.user.controllers.entities

class UserResponse(
    var email: String?,
    var name: String?
) {

    constructor() : this(null, null)

    companion object {
        fun builder(): UserResponseBuilder = UserResponseBuilder(UserResponse())
    }

    /**
     * UserResponse entity Builder class
     */
    class UserResponseBuilder(private val userResponse: UserResponse) {

        fun name(name: String?) : UserResponseBuilder {
            userResponse.name = name
            return this
        }

        fun email(email: String?) : UserResponseBuilder {
            userResponse.email = email
            return this
        }

        fun build() : UserResponse = userResponse
    }

}