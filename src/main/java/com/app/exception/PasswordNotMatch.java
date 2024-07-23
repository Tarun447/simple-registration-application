package com.app.exception;


import lombok.Data;

@Data
public class PasswordNotMatch extends RuntimeException{
    private String message;
    private int statusCode;

    public PasswordNotMatch(String message, int statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }
}
