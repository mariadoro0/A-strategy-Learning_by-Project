package com.astrategy.pokemine.repos;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.entities.UserCollection;

import org.hibernate.annotations.CollectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionDAO extends JpaRepository<UserCollection, CollectionId> {
	
	  // Trova la collezione dell'utente autenticato (username/email) fatto da CHATGPT, ti mando anche il resto tra poco.
    UserCollection findByUsername(String username);

    // Trova tutte le carte possedute dall'utente (attraverso la collezione)
    List<Card> findCarteByUsername(String username);
   

}
