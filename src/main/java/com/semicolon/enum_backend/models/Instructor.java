package com.semicolon.enum_backend.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter

public class Instructor extends User{
    private Long organizationId;
    @OneToMany
    private List<Course> courses;
    @Enumerated(EnumType.STRING)
    private Status instructorStatus;
    private LocalDate dateAdded;
    private LocalDate lastActivity;
}
