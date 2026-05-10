package com.zosh.exception;

import com.zosh.payload.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<UserResponse>  userException(UserException ex, WebRequest req){
        UserResponse userResponse = new UserResponse(ex.getMessage(),req.getDescription(false),
                LocalDateTime.now());
        return ResponseEntity.ok(userResponse);
    }
}
