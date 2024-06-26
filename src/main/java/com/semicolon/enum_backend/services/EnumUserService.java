package com.semicolon.enum_backend.services;

import com.semicolon.enum_backend.dto.request.RegisterUserRequest;
import com.semicolon.enum_backend.dto.response.RegisterUserResponse;
import com.semicolon.enum_backend.exceptions.UserAlreadyExistException;
import com.semicolon.enum_backend.exceptions.UserNotFoundException;
import com.semicolon.enum_backend.models.User;
import com.semicolon.enum_backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j

public class EnumUserService implements UserService{
    private final UserRepository userRepository;

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
        return userRepository.findByFirstName(admin).orElseThrow(()-> new UserNotFoundException("Admin not found "));
    }

    @Override
    public boolean adminExists() {
        return false;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with " + email + " does not exist")));
    }
}
