package com.example.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.services.UserService;
@RestController()
@RequestMapping("/user")
public class UserController {
    
    private UserService uService;
    @Autowired
    public UserController(UserService uService) {
        this.uService = uService;
    }
    @PostMapping("/")
    public ResponseEntity<Object> createUser(@RequestBody User u ){
        return new ResponseEntity<>(uService.saveUser(u), HttpStatus.CREATED);

    }
    @PostMapping("/login")
    public @ResponseBody String LogingUser(@RequestBody LinkedHashMap<String, String> body){
        String username = body.get("username");
		String password = body.get("password");
        return uService.login(username, password);

    }
}