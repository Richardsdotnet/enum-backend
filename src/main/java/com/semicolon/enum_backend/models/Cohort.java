package com.semicolon.enum_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cohort {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String Description;
    @Enumerated(value = EnumType.STRING)
    private Program program;
    private String programType;
    private String startDate;
    private String endDate;
    private  String message;
    private String avatar;



    public Cohort(String message) {
        this.message = message;
    }
}
