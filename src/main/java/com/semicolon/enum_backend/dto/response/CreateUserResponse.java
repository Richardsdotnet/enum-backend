package com.semicolon.enum_backend.dto.response;
import com.semicolon.enum_backend.models.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class CreateUserResponse {
    private String message;
    private User user;

}
