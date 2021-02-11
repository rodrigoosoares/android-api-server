package com.personal.backendapi.user.fixtures

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.personal.backendapi.user.gateways.entities.User

class UserTemplates implements TemplateLoader{

    public static final String JOHN_USER = "John user"
    public static final String BELLA_USER = "Bella user"

    @Override
    void load() {
        Fixture.of(User).addTemplate(JOHN_USER, new Rule(){
            {
                add("id", 1)
                add("name", "John")
                add("email", "john@email.com")
                add("password", "123")
            }
        })

        Fixture.of(User).addTemplate(BELLA_USER, new Rule(){
            {
                add("id", 2)
                add("name", "Bella")
                add("email", "bella@email.com")
                add("password", "321")
            }
        })

    }
}
