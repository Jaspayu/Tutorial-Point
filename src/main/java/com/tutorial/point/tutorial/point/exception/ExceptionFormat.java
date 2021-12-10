package com.tutorial.point.tutorial.point.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionFormat {
    String message;
    LocalDate timeStamp;
    HttpStatus httpStatus;
}
