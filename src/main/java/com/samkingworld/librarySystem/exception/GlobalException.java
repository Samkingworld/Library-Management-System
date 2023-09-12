package com.samkingworld.librarySystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidInputException(MethodArgumentNotValidException exception) {
        Map<String, String> errorDetails = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(
                error -> errorDetails.put(error.getField(), error.getDefaultMessage())
        );
        return errorDetails;
    }

    public Map<String, String> handleInternalErrorException(MethodArgumentNotValidException exception) {
        Map<String, String> errorDetails = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(
                error -> errorDetails.put(error.getField(), error.getDefaultMessage())
        );
        return errorDetails;
    }
}
