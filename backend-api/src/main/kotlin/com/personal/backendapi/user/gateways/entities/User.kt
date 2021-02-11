package com.personal.backendapi.user.gateways.entities

class User (
    var id: Int?,
    var name: String?,
    var email: String?,
    var password: String?
) {

    constructor() : this(null, null, null, null)


    companion object {
        fun builder(): UserBuilder = UserBuilder(User())
    }

    /**
     * UserResponse entity Builder class
     */
    class UserBuilder(private val user: User) {

        fun id(id: Int?) : UserBuilder {
            user.id = id
            return this
        }

        fun name(name: String?) : UserBuilder {
            user.name = name
            return this
        }

        fun email(email: String?) : UserBuilder {
            user.email = email
            return this
        }

        fun password(password: String?) : UserBuilder {
            user.password = password
            return this
        }

        fun build() : User = user
    }

}