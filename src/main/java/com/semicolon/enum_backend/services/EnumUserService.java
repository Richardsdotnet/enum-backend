package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.dto.request.RegisterUserRequest;
import com.semicolon.enum_backend.dto.response.RegisterUserResponse;
import com.semicolon.enum_backend.exceptions.UserAlreadyExistException;
import com.semicolon.enum_backend.models.User;
import com.semicolon.enum_backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class EnumUserService implements UserService{
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) throws UserAlreadyExistException {
        Optional<User> existingUser = userRepository.findByEmail(registerUserRequest.getEmail());

        RegisterUserResponse response = new RegisterUserResponse();

        if (existingUser.isPresent()) {
            response.setMessage("User already exists");
        } else {
            User user = new User();
            BeanUtils.copyProperties(registerUserRequest, user);
            userRepository.save(user);
            response.setMessage("Successful");
        }

        return response;
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
