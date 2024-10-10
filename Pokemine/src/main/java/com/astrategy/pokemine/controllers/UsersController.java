package com.astrategy.pokemine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.services.UsersService;

public class UserController {
	 
	@Autowired
	 private UsersService userService;
	
	@Autowired
	 private User user;
	
	@PostMapping("add")
    public ResponseEntity<String> add(@RequestBody User user) {
        try {
            userService.addUser(user);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
		
	}


