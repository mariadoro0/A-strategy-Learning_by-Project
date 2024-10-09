package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.UserCollectionId;
import com.astrategy.pokemine.entities.UserCollection;

public interface UserCollectionService {

	
	void addCardToCollection(UserCollectionId cid);
	void removeCardToCollection(UserCollectionId Cid);
	UserCollection getUserCollection(int UserId);

	
}
