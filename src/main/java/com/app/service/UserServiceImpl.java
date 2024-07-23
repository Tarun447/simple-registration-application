package com.app.service;

import com.app.dto.UserDto;
import com.app.model.SecurityQuestion;
import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;



    @Override
    public User saveUser(UserDto userDto) throws Exception {
        if(userDto!=null||userDto.getUsername()!="")
        {
            if(userDto.getPassword().equals(userDto.getConfirmPassword()))
            {
                User user = new User(userDto.getUsername(),userDto.getEmail(),userDto.getPassword(),
                        new SecurityQuestion(userDto.getQuestion(),userDto.getAnswer()));
                user = repo.save(user);
                return user;
            }else{
                throw new RuntimeException("Passwod is not valid.");
            }
        }else {
           throw new Exception("Please send valid Data ");
        }
    }

    @Override
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @Override
    public User findUserById(int id) throws Exception {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found with this id.."));
        return user;
    }

    @Override
    public String deleteUserById(int id) throws Exception {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found with this id.."));
        repo.delete(user);
        return "User Record has been deleted with this id : "+id;
    }

    @Override
    public User updateUser(UserDto dto) throws Exception {
        if(dto!=null||dto.getUsername()!=""|| dto.getId()==0||dto.getQId()==0)
        {
            User user = repo.findById(dto.getId()).orElseThrow(()->new RuntimeException("User not found with this id"));
            if(dto.getPassword().equals(dto.getConfirmPassword()))
            {
                user.setUsername(dto.getUsername());
                user.setEmail(dto.getEmail());
                user.setPassword(dto.getPassword());
                SecurityQuestion sc = user.getSecurityQuestion();
                sc.setQuestion(dto.getQuestion());
                sc.setAnswer(dto.getAnswer());
                user.setSecurityQuestion(sc);
                return repo.save(user);
            }else{
                throw new RuntimeException("Passwod is not valid.");
            }
        }else {
            throw new Exception("Please send valid User Record ");
        }
    }


}
