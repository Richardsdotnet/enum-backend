package com.semicolon.enum_backend.exceptions;

public class CohortNotFoundException extends RuntimeException{
    public CohortNotFoundException(String message){
        super(message);
    }
}
