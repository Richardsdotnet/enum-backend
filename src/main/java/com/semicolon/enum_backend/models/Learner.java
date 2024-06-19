package com.semicolon.enum_backend.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class Learner {
    private int noOfPrograms;
    @Enumerated(EnumType.STRING)
    private Status learnerStatus;
    private Long organizationId;
    private LocalDate dateAdded;
    private LocalDate lastActivity;
}
