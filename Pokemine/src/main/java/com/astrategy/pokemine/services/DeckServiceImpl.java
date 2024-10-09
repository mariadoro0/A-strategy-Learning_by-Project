package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.*;
import com.astrategy.pokemine.repos.CardDAO;
import com.astrategy.pokemine.repos.DeckCardDAO;
import com.astrategy.pokemine.repos.DeckDAO;
import com.astrategy.pokemine.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void addCardToDeck(int userId, int deckId, String cardId) {
        User user = userDAO.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utente con id: " + userId+" non trovato."));
        Card card = cardDAO.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Utente con id: " + userId+" non trovato."));
        Deck deck = deckDAO.findById(deckId)
                .orElseThrow(() -> new IllegalArgumentException("Mazzo con id: " + deckId+" non trovato."));
        //Verifica che l'utente sia il proprietario del mazzo
        if(!user.equals(deck.getUser())){
            throw new IllegalArgumentException("Il mazzo non appartiene all'utente selezionato");
        }
        // Verifica se la carta è una Carta Energia Base
        boolean isBasicEnergy = card.getSupertype().equals("Energy") && card.getSubtypes().stream()
                .anyMatch(subtype -> subtype.getName().equals("Basic"));

        DeckCardId id = new DeckCardId(deck.getId(), card.getId());
        Optional<DeckCard> record = deckCardDAO.findById(id);
        DeckCard cardToAdd;

        if (record.isPresent()) {
            cardToAdd = record.get();

            // Controlla che la quantità non sia maggiore di 4, solo se non è una Carta Energia Base
            if (!isBasicEnergy && cardToAdd.getQuantity() >= 4) {
                throw new IllegalArgumentException("Non puoi aggiungere più di 4 copie della stessa carta non-Energia Base.");
            }

            cardToAdd.setQuantity(cardToAdd.getQuantity() + 1);
        } else {
            cardToAdd = new DeckCard();
            cardToAdd.setCard(card);
            cardToAdd.setDeck(deck);
            cardToAdd.setId(id);
            cardToAdd.setQuantity(1);
        }

        deckCardDAO.save(cardToAdd);

    }

    @Override
    public void removeCardFromDeck(int userId, int deckId, String cardId) {
        User user = userDAO.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utente con id: " + userId+" non trovato."));
        Card card = cardDAO.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Carta non trovata con id: " + cardId));
        Deck deck = deckDAO.findById(deckId)
                .orElseThrow(() -> new IllegalArgumentException("Mazzo con id: " + deckId+" non trovato."));
        if(!user.equals(deck.getUser())){
            throw new IllegalArgumentException("Il mazzo non appartiene all'utente selezionato");
        }
        DeckCardId id = new DeckCardId(deckId,cardId);
        Optional<DeckCard> record = deckCardDAO.findById(id);
        DeckCard cardToAdd;
        if (record.isPresent()) {
            cardToAdd = record.get();
            if (cardToAdd.getQuantity() == 1){
                deckCardDAO.delete(cardToAdd);
            }else {
                cardToAdd.setQuantity(cardToAdd.getQuantity() - 1);
                deckCardDAO.save(cardToAdd);
            }
        } else {
            throw new IllegalArgumentException("Mazzo con id: " + cardId+" non trovato.");
        }
    }

    @Override
    public List<Deck> getDecksByUser(int userId) {
        return deckDAO.findByUserId(userId);
    }

    @Override
    public boolean validateDeck(int deckId) {
        Deck deck = findDeckById(deckId);
        //if there are 60 cards and at least one Basic Pokémon, it is valid
        // so it comes back true
        return deckCount(deck) && checkBaseCard(deck);

    }

    // this method checks the number of cards in the deck: to be valid it must be 60
    public boolean deckCount(Deck deck){
        int sum = deck.getDeckCards().stream()
                .mapToInt(DeckCard::getQuantity)
                .sum();
        return sum == 60;
    }

    // this method checks if there is at least one Basic Pokémon in the deck
    public boolean checkBaseCard(Deck deck){
        return deck.getDeckCards().stream()
                .map(DeckCard::getCard)
                .filter(card -> card.getSupertype().equals("Pokémon"))
                .flatMap(card -> card.getSubtypes().stream())
                .anyMatch(subtype -> subtype.getName().equals("Basic"));
    }

    @Override
    public Map<String, Integer> getDeckCardsByDeckId(int deckId) {
        // Trova il mazzo tramite il suo ID
        Deck deck = findDeckById(deckId);

        // Ottieni tutte le DeckCard associate a questo Deck
        List<DeckCard> deckCards = deckCardDAO.findByDeck(deck);

        // Trasforma le DeckCard in una mappa Card -> Quantità
        return deckCards.stream()
                .collect(Collectors.toMap(deckCard -> deckCard.getCard().getId(), DeckCard::getQuantity));
    }

    @Override
    public Deck findDeckById(int deckId) {
        return deckDAO.findById(deckId)
                .orElseThrow(() -> new IllegalArgumentException("Deck not found with id: " + deckId));
    }

    @Override
    public void deleteDeck(int deckId) {
        deckDAO.deleteById(deckId);
    }
}
