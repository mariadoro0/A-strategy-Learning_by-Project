package com.astrategy.pokemine.controllers;

import com.astrategy.pokemine.entities.Deck;
import com.astrategy.pokemine.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // Indicates that this class is a REST controller
@RequestMapping("decks") // Maps HTTP requests to /decks URL path
public class DeckController {
    @Autowired
    private DeckService deckService;

    // HTTP GET method to retrieve all decks for a specific user
    @GetMapping("{userId}")
    public ResponseEntity<List<Deck>> getUserDecks(@PathVariable int userId) {
        return new ResponseEntity<>(deckService.getDecksByUser(userId), HttpStatus.OK); // Returns the list of decks for the user
    }
    
    // HTTP POST method to create a new deck for a specific user
    @PostMapping("{userId}/newdeck")
    public ResponseEntity<String> createDeck(@PathVariable int userId, @RequestParam String name, @RequestParam String description){
        try {
            deckService.createDeck(userId, name, description); // Calls the service to create a new deck
            return new ResponseEntity<>("New deck created succesfully.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // Returns error message if an exception occurs
        }
    }
    
    // HTTP GET method to retrieve cards in a specific deck
    @ResponseBody // Indicates that the method's return value should be written directly to the HTTP response body
    @GetMapping("{userId}/{deckId}")
    public ResponseEntity<?> getDeckCards(@PathVariable int userId, @PathVariable int deckId) {
        try {
            Map<String, Integer> deckCards = deckService.getDeckCardsByDeckId(userId, deckId); // Retrieves cards of the specified deck
            return new ResponseEntity<>(deckCards, HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // Returns error message if an exception occurs
        }
    }
    
    // HTTP GET method to validate a specific deck
    @GetMapping("{userId}/{deckId}/validate")
    public ResponseEntity<String> validateDeck(@PathVariable int userId, @PathVariable int deckId) {
    	try {
            String valid = deckService.validateDeck(deckId); // Validates the specified deck
            return new ResponseEntity<>(valid, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
       
    }
    
    // HTTP POST method to add a card to a specific deck
    @PostMapping("{userId}/{deckId}/add")
    public ResponseEntity<String> addCardToDeck(@PathVariable int userId, @PathVariable int deckId, @RequestParam String cardId) {
        try {
            deckService.addCardToDeck(userId, deckId, cardId); // Calls service to add the specified card to the deck
            return new ResponseEntity<>("Card added to the deck", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // Returns error message if an exception occurs
        }
    }
    
    // HTTP POST method to add a card to a specific deck
    @PostMapping("{userId}/{deckId}/remove")
    public ResponseEntity<String> removeCardFromDeck(@PathVariable int userId, @PathVariable int deckId, @RequestParam String cardId) {
        try {
            deckService.removeCardFromDeck(userId, deckId, cardId); // Calls service to remove the specified card from the deck
            return new ResponseEntity<>("Card removed from the deck", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
 // HTTP GET method to delete a specific deck
    @GetMapping("{userId}/{deckId}/deletedeck")
    public ResponseEntity<String> deleteDeck(@PathVariable int userId, @PathVariable int deckId) {
        try {
            deckService.deleteDeck(deckId); // Calls service to delete the specified deck
            return new ResponseEntity<>("Deck deleted.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}