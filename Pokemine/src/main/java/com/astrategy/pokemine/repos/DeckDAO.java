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
    List<Deck> findByUserId(int userId);
    void deleteById(int deckId);
}
