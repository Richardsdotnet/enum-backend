package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.models.User;

import java.util.Optional;

public interface AdminService {
    User findAdminByFirstName(String name);
}
