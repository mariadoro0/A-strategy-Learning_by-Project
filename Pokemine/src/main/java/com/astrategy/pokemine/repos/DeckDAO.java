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
    
	// Method to find all Decks associated with a specific user by user ID.
	List<Deck> findByUserId(int userId);
    
    // Method to delete a Deck by its ID.
    void deleteById(int deckId);
}
