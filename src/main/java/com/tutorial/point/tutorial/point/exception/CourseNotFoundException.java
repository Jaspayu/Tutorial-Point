package com.tutorial.point.tutorial.point.exception;

public class CourseNotFoundException extends RuntimeException{
    String message;

    public CourseNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
