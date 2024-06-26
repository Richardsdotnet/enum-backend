package com.semicolon.enum_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cohort {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String Description;
    @Enumerated(value = EnumType.STRING)
    private Program program;
    private String startDate;
    private String endDate;
    private String avatar;

    private String programType;
    private  String message;



    public Cohort(String message) {
        this.message = message;
    }
}
