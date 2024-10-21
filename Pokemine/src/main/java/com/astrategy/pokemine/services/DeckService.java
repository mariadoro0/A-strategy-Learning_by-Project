package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.Deck;

import java.util.List;
import java.util.Map;

public interface DeckService {
	// Method to create a new deck for a user.
    void createDeck(int userId, String deckName, String deckDescription);
    // Method to add a card to a user's deck.
    void addCardToDeck(int userId, int deckId, String cardId); 
    // Method to remove a card from a user's deck.
    void removeCardFromDeck(int userId, int deckId, String cardId);
    // Method to retrieve a list of decks for a specific user.
    List<Deck> getDecksByUser(int userId); 
    // Method to validate the contents of a deck.
    String validateDeck(int deckId); 
    // Method to get a map of card quantities in a specific deck.
    Map<String,Integer> getDeckCardsByDeckId(int userId,int deckId);
    // Method to find a deck by its ID.
    Deck findDeckById(int deckId);
    // Method to delete a deck by its ID.
    void deleteDeck(int deckId);
}
