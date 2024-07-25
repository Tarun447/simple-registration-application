package com.app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@NotNull
@Data
public class ResetPasswordDto {

    @NotNull(message = "Id can't be empty")
    private int qId;

    @NotEmpty(message = "answer can't be empty")
    @Size(min=3,message = "answer should be at least 3 char long")
    private String answer;


    @NotEmpty(message = "Password can't be empty")
    @Size(min= 8,message = "password should be at least 8 characters long")
    private String password;

}
