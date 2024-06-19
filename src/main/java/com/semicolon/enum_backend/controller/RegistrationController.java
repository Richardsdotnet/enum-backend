package com.semicolon.enum_backend.controller;

import com.semicolon.enum_backend.dto.request.RegisterUserRequest;
import com.semicolon.enum_backend.dto.response.RegisterUserResponse;
import com.semicolon.enum_backend.exceptions.UserAlreadyExistException;
import com.semicolon.enum_backend.services.EnumUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final EnumUserService enumUserService;
    @PostMapping("/register")

    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest request){
    try{
        return new ResponseEntity<>(enumUserService.registerUser(request), HttpStatus.OK);
    }catch (UserAlreadyExistException exception){
        return new ResponseEntity<>(new RegisterUserResponse(exception.getMessage()), HttpStatus.BAD_REQUEST );
    }
    }

}
