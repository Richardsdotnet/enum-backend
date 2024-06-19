package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.dto.request.CreateUserRequest;
import com.semicolon.enum_backend.dto.response.CreateUserResponse;
import com.semicolon.enum_backend.exceptions.UserAlreadyExistException;
import com.semicolon.enum_backend.models.User;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class EnumUserService implements UserService{

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) throws UserAlreadyExistException {
        return null;
    }

    @Override
    public User findByFirstName(String admin) {
        return null;
    }

    @Override
    public boolean adminExists() {
        return false;
    }

    @Override
    public User findById(Long instructorId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
