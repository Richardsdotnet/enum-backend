package com.semicolon.enum_backend.models;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service

public class Recipient {
    private String name;
    private String email;
}
