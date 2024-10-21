package com.astrategy.pokemine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.services.UserService;

@RestController // Indicates that this class is a REST controller
@RequestMapping("users") // Maps all requests starting with "/users" to this controller
public class UserController {
	 
	@Autowired // Automatically injects the UserService bean
	private UserService userService;

	// POST method to create a new user
	@PostMapping("signin")
    public ResponseEntity<String> add(@RequestBody User user) {
        try {
            userService.addUser(user); // Calls the service to add the new user
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
        	// Return error message with a 400 BAD REQUEST if an exception occurs
            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
	
	
	// GET method to delete a user account
	@GetMapping("deleteaccount")
	public ResponseEntity<String> delete(@RequestParam int id) {
	    try {
	        userService.deleteById(id); // Calls the service to delete the user by ID
	        return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
	    } catch (Exception e) {
	    	// Return error message with a 400 BAD REQUEST if an exception occurs
	        return new ResponseEntity<>("Error: ID not present - " + e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	// GET method to delete a user account
	@GetMapping("deactivate")
	public ResponseEntity<String> deactivate(@RequestParam int id) {
		try {
			userService.deactivateUser(id); // Calls the service to deactivate the user by ID
			return new ResponseEntity<>("Account deactivated successfully.", HttpStatus.OK);
		} catch (Exception e) {
			// Return error message with a 400 BAD REQUEST if an exception occurs
			return new ResponseEntity<>("Error: ID not present - " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
		
}


