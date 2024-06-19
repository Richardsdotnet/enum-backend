package com.semicolon.enum_backend.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public enum Role {
    ADMIN,
    INSTRUCTOR,
    ORGANIZATION,
    LEARNER;
}
