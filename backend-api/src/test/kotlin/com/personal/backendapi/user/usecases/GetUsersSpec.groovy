package com.personal.backendapi.user.usecases

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
import com.personal.backendapi.user.fixtures.UserTemplates
import com.personal.backendapi.user.gateways.UserGateway
import com.personal.backendapi.user.gateways.entities.User
import spock.lang.Specification

import static com.personal.backendapi.user.fixtures.UserTemplates.BELLA_USER
import static com.personal.backendapi.user.fixtures.UserTemplates.JOHN_USER

class GetUsersSpec extends Specification {

    def setup() {
        FixtureFactoryLoader.loadTemplates(UserTemplates.packageName)
    }

    UserGateway userGateway = Mock()

    GetUsers getUsers = new GetUsers(userGateway)

    def "Get all users successfully"() {
        setup:
        def usersResponse = [
            Fixture.from(User).gimme(JOHN_USER),
            Fixture.from(User).gimme(BELLA_USER)
        ]

        when: "call use case execute method"
        def result = getUsers.execute()

        then: "should call the gateway"
        1 * userGateway.getAllUsers() >> usersResponse

        and: "should return the list returned by gateway"
        result == usersResponse
    }

}
