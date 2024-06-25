package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.dto.request.RegisterUserRequest;
import com.semicolon.enum_backend.dto.response.RegisterUserResponse;
import com.semicolon.enum_backend.exceptions.UserAlreadyExistException;
import com.semicolon.enum_backend.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) throws UserAlreadyExistException;

    User findByFirstName(String admin);

    boolean adminExists();

    User findById(Long instructorId);

    List<User> findAll();

    void delete(User user);

    Optional<User> findByEmail(String mail);
}
