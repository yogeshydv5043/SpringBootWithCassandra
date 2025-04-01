package com.learn.ms.cassandra.exception;

import com.learn.ms.cassandra.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(exception.getMessage());
        response.setTimestamp(LocalDateTime.now());
        response.setPath(webRequest.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
