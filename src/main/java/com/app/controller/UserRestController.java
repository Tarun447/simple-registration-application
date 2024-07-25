package com.app.controller;


import com.app.dto.ForgetPasswordDto;
import com.app.dto.ResetPasswordDto;
import com.app.dto.UserLoginDto;
import com.app.model.User;
import com.app.service.UserService;
import com.app.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserRestController {

    @Autowired
    private UserService service;

        @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserDto dto) throws Exception
    {
        return  new ResponseEntity<String>(service.saveUser(dto), HttpStatus.CREATED);
    }




    @GetMapping("/forget/{id}")
    public ResponseEntity<?> forgetpassword(@PathVariable  int id) throws Exception
    {
        return ResponseEntity.ok(service.forgetPasswordbyId(id));
    }




    @PostMapping("reset/{id}")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDto dto, @PathVariable int id) throws Exception
    {
        return ResponseEntity.ok(service.resetById(dto,id));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody @Valid UserLoginDto dto) throws  Exception
    {
        return  ResponseEntity.ok(service.login(dto));
    }

}
