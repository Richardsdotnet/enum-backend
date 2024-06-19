package com.semicolon.enum_backend.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

public class Instructor {
    private Long organizationId;
    @OneToMany
    private List<Course> courses;
    @Enumerated(EnumType.STRING)
    private Status instructorStatus;
    private LocalDate dateAdded;
    private LocalDate lastActivity;
}
