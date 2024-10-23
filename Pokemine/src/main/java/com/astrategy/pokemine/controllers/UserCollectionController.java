package com.astrategy.pokemine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.astrategy.pokemine.entities.UserCollection;
import com.astrategy.pokemine.services.UserCollectionService;


//Indicates that this class is a REST controller
@RestController
@RequestMapping("collection") // Maps all requests starting with "/collection" to this controller
public class UserCollectionController {
    @Autowired
    private UserCollectionService service;
    
    // GET method to retrieve the user's card collection
	@GetMapping("{userId}")
	public ResponseEntity<?> getCards(@PathVariable int userId) {
		// Fetch the user's collection from the service
		try {
			List<UserCollection> collection = service.getUserCollection(userId);
			return new ResponseEntity<>(collection, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// POST method to add a card to the user's collection
	@PostMapping("{userId}/add")
	public ResponseEntity<String> addCard(@PathVariable int userId, @RequestParam String cardId) {
		 try {
			 service.addCardToCollection(userId,cardId); // Calls the service to add the specified card to the user's collection
			 return ResponseEntity.ok("Card added to the collection");
		 } catch(Exception e){
			 // Return error message with a 500 INTERNAL SERVER ERROR if any exception occurs
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		 }
	}

	// POST method to remove a card from the user's collection
	 @PostMapping("{userId}/remove")
	public ResponseEntity<String> removeCard(@PathVariable int userId, @RequestParam String cardId) {
		 try {
			 service.removeCardToCollection(userId,cardId);
			 return ResponseEntity.ok("Card removed from the collection"); // Calls the service to remove the specified card from the user's collection
		 } catch(Exception e){
			// Return error message with a 500 INTERNAL SERVER ERROR if any exception occurs
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		 }
	    }

}
