package com.tutorial.point.tutorial.point.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@RestController
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleNoUserFoundException(Exception ex, WebRequest request){
        ExceptionFormat exceptionFormat = new ExceptionFormat(ex.getMessage(), LocalDate.now(),
                HttpStatus.NOT_FOUND,"User Not Found Exception");
        return new ResponseEntity<>( exceptionFormat, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CourseNotFoundException.class)
    public final ResponseEntity<Object> handleNoCourseFoundException(Exception ex, WebRequest request){
        ExceptionFormat exceptionFormat = new ExceptionFormat(ex.getMessage(), LocalDate.now(),
                HttpStatus.NOT_FOUND, "Course Not Found Exception");
        return new ResponseEntity<>( exceptionFormat, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionFormat exceptionFormat = new ExceptionFormat(ex.getMessage(),LocalDate.now(),
                HttpStatus.NOT_FOUND, "Handler Not Found Exception");
        return new ResponseEntity<>(exceptionFormat, HttpStatus.NOT_FOUND);
    }

}
