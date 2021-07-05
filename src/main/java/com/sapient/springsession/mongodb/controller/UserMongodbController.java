package com.sapient.springsession.mongodb.controller;

import com.sapient.springsession.mongodb.model.User;
import com.sapient.springsession.mongodb.repository.IUserMongodbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserMongodbController {
    @Autowired
    private IUserMongodbRepository userMongodbRepository;

    @GetMapping("/mongodb/users")
    public ResponseEntity fetchAllUsers(){
        List<User> all = userMongodbRepository.findAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }
}
