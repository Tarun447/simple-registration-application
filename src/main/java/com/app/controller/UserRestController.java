package com.app.controller;


import com.app.model.User;
import com.app.service.UserService;
import com.app.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserRestController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto dto) throws Exception
    {
        return  new ResponseEntity<User>(service.saveUser(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers()
    {
        return  ResponseEntity.ok(service.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable  int id) throws Exception
    {
        return ResponseEntity.ok(service.findUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteUserById(@PathVariable int id) throws Exception
    {
        return ResponseEntity.ok(service.deleteUserById(id));
    }


    @PutMapping
    public ResponseEntity<?> updateUserById( @RequestBody UserDto dto) throws Exception
    {
        return ResponseEntity.ok(service.updateUser(dto));
    }


}
