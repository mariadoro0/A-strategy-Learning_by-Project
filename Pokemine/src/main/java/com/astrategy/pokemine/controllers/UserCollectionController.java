package com.astrategy.pokemine.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.entities.UserCollection;
import com.astrategy.pokemine.entities.UserCollectionId;
import com.astrategy.pokemine.services.CardService;
import com.astrategy.pokemine.services.UserCollectionService; // DA FARE
import com.astrategy.pokemine.services.UserService; // DA FARE

@RestController
@RequestMapping("pokemon/collection")
public class UserCollectionController {
    @Autowired
    private UserCollectionService service; // DA FARE
    @Autowired
    private UserService userService; // DA FARE
    @Autowired
    private CardService cardService; // FATTO
    
    
@GetMapping("{userId}")
public ResponseEntity<UserCollection> getCards(@PathVariable int userId) { 
    UserCollection collection = service.getUserCollection(userId); // RICORDARSI DI CREARE IL SERVICE USERCOLLECTIONSERVICES
    if (collection == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Restituisce 404 se non trovata e potremmo anche personalizzare la pagina 404
    }
    return new ResponseEntity<>(collection, HttpStatus.OK); // Restituisce 200 con la collezione
    }

@PostMapping("/add")
public ResponseEntity<String> addCard(@RequestBody UserCollectionId uid) {
    // Controlla se l'utente esiste
    Optional<User> user = userService.getUserById(uid.getUserId());
    if (user.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato");
    }

    // Controlla se la carta esiste
    Card card = cardService.getCard(uid.getCardId());
    if (card == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carta non trovata");
    }

    // Aggiungi la carta alla collezione
    service.addCardToCollection(uid);
    return ResponseEntity.ok("Carta aggiunta alla collezione");
}
}
