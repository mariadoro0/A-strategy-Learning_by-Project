package com.astrategy.pokemine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.astrategy.pokemine.entities.UserCollection;
import com.astrategy.pokemine.services.UserCollectionService;



@RestController
@RequestMapping("collection")
public class UserCollectionController {
    @Autowired
    private UserCollectionService service;
    
    
	@GetMapping("{userId}")
	public ResponseEntity<List<UserCollection>> getCards(@PathVariable int userId) {
	    List<UserCollection> collection = service.getUserCollection(userId);
	    if (collection == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Restituisce 404 se non trovata e potremmo anche personalizzare la pagina 404
	    }
	    return new ResponseEntity<>(collection, HttpStatus.OK); // Restituisce 200 con la collezione
	}

	@PostMapping("{userId}/add")
	public ResponseEntity<String> addCard(@PathVariable int userId, @RequestParam String cardId) {
		 try {
			 service.addCardToCollection(userId,cardId);
			 return ResponseEntity.ok("Carta aggiunta alla collezione");
		 } catch(Exception e){
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		 }
	}

	 @PostMapping("{userId}/remove")
	public ResponseEntity<String> removeCard(@PathVariable int userId, @RequestParam String cardId) {
		 try {
			 service.removeCardToCollection(userId,cardId);
			 return ResponseEntity.ok("Carta rimossa dalla collezione");
		 } catch(Exception e){
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		 }
	    }

}
