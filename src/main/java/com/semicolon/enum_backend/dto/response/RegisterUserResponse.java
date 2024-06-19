package com.semicolon.enum_backend.dto.response;
import com.semicolon.enum_backend.models.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class RegisterUserResponse {
    public RegisterUserResponse(String message) {
        this.message = message;
    }

    private String message;
    private User user;



}
