package com.astrategy.pokemine.repos;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.entities.UserCollection;
import com.astrategy.pokemine.entities.UserCollectionId;
import com.astrategy.pokemine.entities.User;

import org.hibernate.annotations.CollectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCollectionDAO extends JpaRepository<UserCollection, UserCollectionId> {
   
	// Method to find all UserCollection entries associated with a specific User.
	List<UserCollection> findByUser(User user);
}
