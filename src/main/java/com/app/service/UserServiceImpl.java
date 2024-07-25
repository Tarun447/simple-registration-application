package com.app.service;

import com.app.dto.ForgetPasswordDto;
import com.app.dto.ResetPasswordDto;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.exception.PasswordNotMatchException;
import com.app.exception.UserAlreadyPresentException;
import com.app.exception.UserNotFoundException;
import com.app.model.SecurityQuestion;
import com.app.model.User;
import com.app.repository.SecurityQuestionRepository;
import com.app.repository.UserRepository;
import com.app.validation.PasswordMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private SecurityQuestionRepository service;

    @Autowired
    private PasswordMatcher matcher;



    @Override
    public String saveUser(UserDto userDto) throws Exception {

        String str="";

           User us = repo.findByUsername(userDto.getUsername());
            if(us!=null)
            {
               throw new UserAlreadyPresentException(userDto.getUsername()+"is already present in the db..username should be unique..");
            }
            else {

                   if(matcher.isValidPassword(userDto.getPassword()))
                   {
                       SecurityQuestion sc = service.findByQuestion(userDto.getQuestion());
                       User  user = new User(userDto.getUsername().toLowerCase(),userDto.getPassword(),sc.getQId(),userDto.getAnswer());
                       repo.save(user);
                       return "Registration Successfully..";
                   }else {
                       throw  new PasswordNotMatchException("password have at least 1 Upper Case ,1 Lower Case,1 number and 1 special " +
                               "char in (!@#$%^&*)");
                   }

            }

    }




    @Override
    public ForgetPasswordDto forgetPasswordbyId(int id) throws Exception{
        User user = repo.findById(id).orElseThrow(()->new Exception("please enter valid userId"));
        int qId = user.getQId();
        SecurityQuestion securityQuestion = service.findById(qId).orElseThrow(() -> new Exception("Invalid Question Id,Please contact with you Administration"));
        return new ForgetPasswordDto(qId,securityQuestion.getQuestion());
    }

    @Override
    public String resetById(ResetPasswordDto dto, int id) throws Exception {
        User user = repo.findById(id).orElseThrow(()->new Exception("please enter valid userId"));
        if(user.getQId()==dto.getQId() && user.getAnswer().equals(dto.getAnswer()))
        {
            if(matcher.isValidPassword(dto.getPassword()))
            {
                user.setPassword(dto.getPassword());
                repo.save(user);
                return "Reset Password Successful";
            }
            else {
                throw  new PasswordNotMatchException("password have at least 1 Upper Case ,1 Lower Case,1 number and 1 special " +
                        "char in (!@#$%^&*)");
            }
        }else {
            throw  new Exception("Invalid Answer");
        }

    }


    @Override
    public String login(UserLoginDto dto) throws Exception {
        User user = repo.findById(dto.getId()).orElseThrow(()->new Exception("invalid credential"));
        if(user.getPassword().equals(dto.getPassword()))
        {
            return "Login Success";
        }else {
            throw new Exception("Invalid credential");
        }



    }


}
