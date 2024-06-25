package com.semicolon.enum_backend;

import com.semicolon.enum_backend.dto.request.RegisterUserRequest;
import com.semicolon.enum_backend.models.Role;
import com.semicolon.enum_backend.models.User;
import com.semicolon.enum_backend.services.EnumUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest

public class AdminServiceTest {
    @Autowired
    private EnumUserService userService;





    @BeforeEach
    void setUp(){


    }

    @Test
    public void testAdminFound(){

        RegisterUserRequest admin = new RegisterUserRequest();
        admin.setFirstName("Richie");
        admin.setLastName("ATR");
        admin.setEmail("rh@gmail.com");
        admin.setRole(Role.INSTRUCTOR);
        admin.setPassword("123454");
        userService.registerUser(admin);
        assertThat(admin).isNotNull();

        Optional<User> foundAdmin = userService.findByEmail("rh@gmail.com");
        assertThat(foundAdmin).isPresent();

        foundAdmin.ifPresent(user -> {
            assertThat(foundAdmin.get().getFirstName()).isEqualTo("Richie");
            assertThat(foundAdmin.get().getRole()).isEqualTo(Role.INSTRUCTOR);


        });



    }

}
