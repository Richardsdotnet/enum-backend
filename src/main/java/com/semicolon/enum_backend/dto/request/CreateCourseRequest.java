package com.semicolon.enum_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCourseRequest {
    private String name;
    private Long cohortId;
}
