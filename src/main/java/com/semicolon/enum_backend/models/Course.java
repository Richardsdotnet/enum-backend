package com.semicolon.enum_backend.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.AUTO;
@Setter
@Getter

public class Course {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private Long cohortId;
}
