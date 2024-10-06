package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.entities.Deck;
import com.astrategy.pokemine.entities.DeckCard;
import com.astrategy.pokemine.entities.DeckCardId;

import java.util.List;

public interface DeckService {
    void createDeck(int userId, String deckName, String deckDescription); // Crea un mazzo con le carte dalla collezione personale
    void addCardToDeck(DeckCardId dcId); // Aggiunge una carta a un mazzo esistente
    void removeCardFromDeck(DeckCardId dcId); // Rimuove una carta da un mazzo esistente
    List<Deck> getDecksByUser(int userId); // Ritorna tutti i mazzi creati dall'utente
    boolean validateDeck(int deckId); // Verifica che il mazzo sia conforme al regolamento
    List<Card> getDeckCardsByDeckId(int deckId);
    Deck findDeckById(int deckId);
    void deleteDeck(int deckId);
}
