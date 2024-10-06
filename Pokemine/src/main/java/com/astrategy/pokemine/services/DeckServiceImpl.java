package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.*;
import com.astrategy.pokemine.repos.CardDAO;
import com.astrategy.pokemine.repos.DeckCardDAO;
import com.astrategy.pokemine.repos.DeckDAO;
import com.astrategy.pokemine.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeckServiceImpl implements DeckService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private DeckDAO deckDAO;
    @Autowired
    private DeckCardDAO deckCardDAO;
    @Autowired
    private CardDAO cardDAO;

    @Override
    public void createDeck(int userId, String deckName, String deckDescription) {
        // searching for the user with the specified id
        User user = userDAO.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        // instantiate new deck
        Deck deck = new Deck(user, deckName, deckDescription);
        //saving deck
        deckDAO.save(deck);
    }

    @Override
    public void addCardToDeck(DeckCardId dcId) {
        //check to see if the given deck and card exist
        Deck deck = findDeckById(dcId.getDeckId());
        Card card = cardDAO.findById(dcId.getCardId())
                .orElseThrow(() -> new IllegalArgumentException("Card not found with id: " + dcId.getCardId()));

        // checking if the card is a base energy card
        boolean isBasicEnergy = card.getSupertype().equals("Energy") && card.getSubtypes().stream()
                .anyMatch(subtype -> subtype.getName().equals("Basic"));

        Optional<DeckCard> record = deckCardDAO.findById(dcId);
        DeckCard cardToAdd = new DeckCard();

        //checks if the card is already in the deck
        if (record.isPresent()) {
            cardToAdd = record.get();
            // if it is not a basic energy, quantity must be max 4
            if (!isBasicEnergy && cardToAdd.getQuantity() >= 4) {
                throw new IllegalArgumentException("Cannot have more than 4 copies of a non-base energy card.");
            }
            cardToAdd.setQuantity(cardToAdd.getQuantity() + 1);
        } else {
            // if the card is not already present in the deck, this adds a new record with quantity=1
            cardToAdd = new DeckCard();
            cardToAdd.setId(dcId);
            cardToAdd.setQuantity(1);
        }

        deckCardDAO.save(cardToAdd);

    }

    @Override
    public void removeCardFromDeck(DeckCardId dcId) {

    }

    @Override
    public List<Deck> getDecksByUser(int userId) {
        return List.of();
    }

    @Override
    public boolean validateDeck(int deckId) {
        return false;
    }

    @Override
    public List<Card> getDeckCardsByDeckId(int deckId) {
        return List.of();
    }

    @Override
    public Deck findDeckById(int deckId) {
        return null;
    }

    @Override
    public void deleteDeck(int deckId) {

    }
}
