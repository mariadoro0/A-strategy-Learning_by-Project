package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.UserCollectionId;
import com.astrategy.pokemine.entities.UserCollection;

import java.util.List;

public interface UserCollectionService {

	
	void addCardToCollection(int userId, String cardId);
	void removeCardToCollection(int userId, String cardId);
	List<UserCollection> getUserCollection(int UserId);

	
}
