package com.app.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    @NotNull(message = "id  can't be empty")
    private int id;


    @NotEmpty(message = "Password can't be empty")
    @Size(min= 8,message = "password should be at least 8 characters long")
    private String password;
}
