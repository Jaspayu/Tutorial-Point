package com.tutorial.point.tutorial.point.exception;

public class UserNotFoundException extends RuntimeException{
    String message;
    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
