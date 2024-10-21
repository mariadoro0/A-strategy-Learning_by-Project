package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.UserCollectionId;
import com.astrategy.pokemine.entities.UserCollection;

import java.util.List;

public interface UserCollectionService {

	// Method to add a card to the user's collection
	void addCardToCollection(int userId, String cardId);
	// Method to remove a card from the user's collection
	void removeCardToCollection(int userId, String cardId);
	// Method to retrieve the entire collection of a user by userId
	List<UserCollection> getUserCollection(int UserId);

	
}
