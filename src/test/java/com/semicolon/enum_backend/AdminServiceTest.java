package com.semicolon.enum_backend;

import com.semicolon.enum_backend.models.Role;
import com.semicolon.enum_backend.models.User;
import com.semicolon.enum_backend.repositories.UserRepository;
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
    private UserRepository userRepository;
    @Autowired
    private EnumUserService userService;






    @BeforeEach
    void setUp(){
        userService = new EnumUserService();

    }

    @Test
    public void testAdminFound(){
        User admin = new User();
        admin.setFirstName("Rich");
        admin.setEmail("rich@gmail.com");
        admin.setRole(Role.ADMIN);
        userService.registerUser(admin);
//        userRepository.save(admin);

        Optional<User> foundAdmin = userRepository.findByFirstName("Rich");
        assertThat(foundAdmin).isPresent();

        foundAdmin.ifPresent(user -> {
            assertThat(foundAdmin.get().getFirstName()).isEqualTo("Rich");
            assertThat(foundAdmin.get().getRole()).isEqualTo(Role.ADMIN);


        });



    }

}
