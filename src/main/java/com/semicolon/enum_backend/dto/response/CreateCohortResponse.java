package com.semicolon.enum_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateCohortResponse {
    private Long id;
    private String message;


    public CreateCohortResponse(String message) {
        this.message= message;
    }
}
