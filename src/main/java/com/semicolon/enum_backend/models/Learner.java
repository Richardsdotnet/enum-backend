package com.semicolon.enum_backend.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter

public class Learner extends User {
    private int noOfPrograms;
    @Enumerated(EnumType.STRING)
    private Status learnerStatus;
    private Long organizationId;
    private LocalDate dateAdded;
    private LocalDate lastActivity;
}
