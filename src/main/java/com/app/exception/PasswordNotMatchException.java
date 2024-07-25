package com.app.exception;


import lombok.Data;

@Data
public class PasswordNotMatchException extends RuntimeException{
    private String message;

    public PasswordNotMatchException(String message) {
        super(message);
        this.message = message;
    }
}
