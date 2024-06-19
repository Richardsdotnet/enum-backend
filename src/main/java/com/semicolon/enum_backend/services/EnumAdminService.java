package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.models.User;
import org.springframework.stereotype.Service;
@Service

public class EnumAdminService implements AdminService{


    @Override
    public User  findAdminByFirstName(String name) {
        return null;
    }
}
