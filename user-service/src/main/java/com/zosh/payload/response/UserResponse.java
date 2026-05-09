package com.zosh.payload.response;


import java.time.LocalDateTime;

public class UserResponse {
    public String message;
    public String error;
    public LocalDateTime localDateTime;

    public UserResponse(String message, String error, LocalDateTime localDateTime) {
        this.message = message;
        this.error = error;
        this.localDateTime = localDateTime;
    }

    public UserResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
