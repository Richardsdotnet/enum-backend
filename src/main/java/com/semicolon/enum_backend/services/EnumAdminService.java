package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.exceptions.UserNotFoundException;
import com.semicolon.enum_backend.models.User;
import com.semicolon.enum_backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EnumAdminService implements AdminService{
    private UserRepository userRepository;


    @Override
    public User findAdminByFirstName(String name) {
        return userRepository.findByFirstName(name).orElseThrow(() -> new UserNotFoundException("User with" + name + "not found"));
    }
}
