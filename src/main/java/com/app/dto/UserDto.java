package com.app.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private int id;


    @NotEmpty(message = "username  can't be empty")
    @Size(min=8,message="user name length should be 8 char long and not space allowed")
    private String username;


    @NotEmpty(message = "Password can't be empty")
    @Size(min= 8,message = "password should be at least 8 characters long")
    private String password;


    private String question;

    @NotEmpty(message = "answer can't be empty")
    @Size(min=3,message = "answer should be at least 3 char long")
    private String answer;

    public UserDto(String username, String password,  String question, String answer) {
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }
}
