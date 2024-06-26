package com.semicolon.enum_backend.dto.request;

import com.semicolon.enum_backend.models.Course;
import com.semicolon.enum_backend.models.Role;
import com.semicolon.enum_backend.models.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private Long organizationId;
    private int noOfPrograms;
    private List<Course> courses;
    private Status userStatus;
    private LocalDate dateAdded;
    private LocalDate lastActivity;
}
