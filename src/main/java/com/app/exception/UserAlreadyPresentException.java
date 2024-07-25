package com.app.exception;

public class UserAlreadyPresentException extends RuntimeException{
    private String message;

    public UserAlreadyPresentException(String message) {
        super(message);
        this.message = message;
    }
}
