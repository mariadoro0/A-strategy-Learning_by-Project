package com.astrategy.pokemine.controllers;

import com.astrategy.pokemine.entities.Deck;
import com.astrategy.pokemine.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pokemon/decks")
public class DeckController {
    @Autowired
    private DeckService deckService;


    @GetMapping("{userId}")
    public ResponseEntity<List<Deck>> getUserDecks(@PathVariable int userId) {
        return new ResponseEntity<>(deckService.getDecksByUser(userId), HttpStatus.OK);
    }

    @PostMapping("{userId}/newdeck")
    public ResponseEntity<String> createDeck(@PathVariable int userId, @RequestParam String name, @RequestParam String description){
        try {
            deckService.createDeck(userId, name, description);
            return new ResponseEntity<>("Nuovo mazzo creato con successo.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @GetMapping("{userId}/{deckId}")
    public ResponseEntity<?> getDeckCards(@PathVariable int userId, @PathVariable int deckId) {
        try {
            Map<String, Integer> deckCards = deckService.getDeckCardsByDeckId(userId, deckId);
            return new ResponseEntity<>(deckCards, HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{userId}/{deckId}/validate")
    public ResponseEntity<String> validateDeck(@PathVariable int userId, @PathVariable int deckId) {
        if(deckService.validateDeck(deckId)) {
            return new ResponseEntity<>("Il mazzo è valido.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Il mazzo non è valido.",HttpStatus.OK);
        }
    }

    @PostMapping("{userId}/{deckId}/add")
    public ResponseEntity<String> addCardToDeck(@PathVariable int userId, @PathVariable int deckId, @RequestParam String cardId) {
        try {
            deckService.addCardToDeck(userId, deckId, cardId);
            return new ResponseEntity<>("Carta aggiunta al mazzo", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("{userId}/{deckId}/remove")
    public ResponseEntity<String> removeCardFromDeck(@PathVariable int userId, @PathVariable int deckId, @RequestParam String cardId) {
        try {
            deckService.removeCardFromDeck(userId, deckId, cardId);
            return new ResponseEntity<>("Carta rimossa dal mazzo", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{userId}/{deckId}/deletedeck")
    public ResponseEntity<String> deleteDeck(@PathVariable int userId, @PathVariable int deckId) {
        try {
            deckService.deleteDeck(deckId);
            return new ResponseEntity<>("Mazzo eliminato.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}