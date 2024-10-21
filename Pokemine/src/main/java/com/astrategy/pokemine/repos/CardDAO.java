package com.astrategy.pokemine.repos;

import com.astrategy.pokemine.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardDAO extends JpaRepository<Card, String>, JpaSpecificationExecutor<Card> {
    
	// Method to find a Card by its ID. The return type is Optional to handle cases where the Card may not be found.
	Optional<Card> findById(String Id);


}
