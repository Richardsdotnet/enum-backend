package com.semicolon.enum_backend;
import com.semicolon.enum_backend.models.Role;
import com.semicolon.enum_backend.models.User;
import com.semicolon.enum_backend.services.EnumAdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest

public class AdminServiceTest {
    @Autowired
    private EnumAdminService enumAdminService;
    @Autowired
    private List<User> users = new ArrayList<>();




    @BeforeEach
    void setUp(){
        enumAdminService = new EnumAdminService();

    }

    @Test
    public void testAdminFound(){
        User admin = new User();
        admin.setFirstName("Ritchie");
        admin.setEmail("rich@gmail.com");
        admin.setRole(Role.ADMIN);
        users.add(admin);

        User foundAdmin = enumAdminService.findAdminByFirstName("Ritchie");
        assertThat(foundAdmin).isNotNull();
        assertThat(foundAdmin.getFirstName()).isEqualTo("Ritchie");
        assertThat(foundAdmin.getRole()).isEqualTo(Role.ADMIN);



    }

}
