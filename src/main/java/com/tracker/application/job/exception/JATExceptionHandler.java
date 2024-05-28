package com.tracker.application.job.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class JATExceptionHandler {

    @ExceptionHandler(JATException.class)
    public ResponseEntity<Object> handleJATException(JATException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", ex.getStatusCode());
        response.put("message", ex.getJatErrorMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatusCode()));
    }

}
