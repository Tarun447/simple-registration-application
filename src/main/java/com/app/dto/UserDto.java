package com.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private int id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private int qId;
    private String question;
    private String answer;

    public UserDto(int id, String username, String email, String password, int qId, String question, String answer) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.qId = qId;
        this.question = question;
        this.answer = answer;
    }

    public UserDto(String username, String email, String password, String confirmPassword, String question, String answer) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.question = question;
        this.answer = answer;
    }


}
