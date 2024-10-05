package com.astrategy.pokemine.repos;

import com.astrategy.pokemine.entities.Deck;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeckDAO extends JpaRepository<Deck, Integer> {
    
	//Search for a card in a deck by card name
    List<Deck> findByCardName(String cardName);
    
    //Delete a single or multiple cards from a deck by card IDs
    @Modifying
    @Transactional
    @Query("DELETE FROM Deck d WHERE d.deckId = :deckId AND d.cardId IN :cardIds")
    int deleteCardsFromDeck(String deckId, List<String> cardIds);
    
    //Create a new deck or update an existing one (depending on whether the deckId exists)
    @Override
    <S extends Deck> S save(S deck);
	
    //Delete an entire deck using its deckId
    void deleteById(String deckId);
}
