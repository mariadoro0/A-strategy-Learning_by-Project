package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.CollectionId;
import com.astrategy.pokemine.entities.UserCollection;

public interface UserCollectionService {

	void AddCardToColletion(CollectionId cid);
	void removeCardToColletion(CollectionId Cid);
	UserCollection getUserCollection(int UserId);
	
}
