package com.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    private String resourceName ;
    private String fieldName;
    private int fieldValue;

    public UserNotFoundException(String resourceName, String fieldName, int fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
