package com.semicolon.enum_backend.exceptions;

public class UserNotFoundException extends RuntimeException{
    public  UserNotFoundException(String message){
        super(message);
    }
}
