package com.semicolon.enum_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class ProgramType {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
}
