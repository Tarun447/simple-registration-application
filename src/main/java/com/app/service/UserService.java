package com.app.service;

import com.app.dto.UserDto;
import com.app.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(UserDto userDto) throws Exception;
    public List<User> getAllUser();
    public User findUserById(int id) throws Exception;
    public String deleteUserById(int id)throws Exception;
    public User updateUser(UserDto dto) throws Exception;
}
