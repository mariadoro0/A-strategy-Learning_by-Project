package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.UserCollectionId;
import com.astrategy.pokemine.entities.UserCollection;

public interface UserCollectionService {

	
	void addCardToColletion(UserCollectionId cid);
	void removeCardToColletion(UserCollectionId Cid);
	UserCollection getUserCollection(int UserId);
	
}
