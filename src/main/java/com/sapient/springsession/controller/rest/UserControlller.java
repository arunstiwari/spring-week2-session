package com.sapient.springsession.controller.rest;

import com.sapient.springsession.model.User;
import com.sapient.springsession.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControlller {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity fetchAllUsers(){
        List<User> users = userService.fetchAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user){
        User savedUser = userService.addUser(user);
        return new ResponseEntity(savedUser, HttpStatus.OK);
    }


}
