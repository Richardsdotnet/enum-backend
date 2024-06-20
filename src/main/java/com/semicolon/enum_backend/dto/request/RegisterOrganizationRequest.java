package com.semicolon.enum_backend.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.semicolon.enum_backend.models.Role;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RegisterOrganizationRequest {

    private Long id;
    private String name;
    private String cac;
    private String email;
    @JsonIgnore
    private String password;
    private Role role;
}
