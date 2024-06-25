package com.semicolon.enum_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Learner extends User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private int noOfPrograms;
    @Enumerated(EnumType.STRING)
    private Status learnerStatus;
    private Long organizationId;
    private LocalDate dateAdded;
    private LocalDate lastActivity;
}
