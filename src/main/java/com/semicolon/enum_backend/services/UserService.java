package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.dto.request.CreateUserRequest;
import com.semicolon.enum_backend.dto.response.CreateUserResponse;
import com.semicolon.enum_backend.exceptions.UserAlreadyExistException;
import com.semicolon.enum_backend.models.User;

import java.util.List;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest createUserRequest) throws UserAlreadyExistException;


    User findByFirstName(String admin);

    boolean adminExists();

    User findById(Long instructorId);

    List<User> findAll();

    void delete(User user);
}
