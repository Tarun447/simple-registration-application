package com.app.service;

import com.app.dto.ForgetPasswordDto;
import com.app.dto.ResetPasswordDto;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.model.User;

import java.util.List;

public interface UserService {

    public String saveUser(UserDto userDto) throws Exception;
    public String login(UserLoginDto dto)throws Exception;
    public ForgetPasswordDto forgetPasswordbyId(int id) throws  Exception;
    public String resetById(ResetPasswordDto dto, int id) throws  Exception;
}
