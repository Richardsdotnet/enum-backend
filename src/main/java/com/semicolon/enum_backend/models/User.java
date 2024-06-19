package com.semicolon.enum_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private String password;
    @Enumerated
    private Role role;
}
