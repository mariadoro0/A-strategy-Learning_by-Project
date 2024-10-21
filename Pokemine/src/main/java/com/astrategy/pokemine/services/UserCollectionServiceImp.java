package com.astrategy.pokemine.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.entities.UserCollectionId;
import com.astrategy.pokemine.entities.UserCollection;
import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.repos.CardDAO;
import com.astrategy.pokemine.repos.UserCollectionDAO;
import com.astrategy.pokemine.repos.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserCollectionServiceImp implements UserCollectionService {

	@Autowired
	private UserCollectionDAO dao;
	@Autowired 
	private UserDAO userDAO;
	@Autowired 
	private CardDAO carddao;

	// Method to add a card to the user's collection
	@Override
	public void addCardToCollection(int userId, String cardId) {
		// Fetch the user by userId or throw an exception if not found
	    User user = userDAO.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User with id : " + userId+" not found."));
	 // Fetch the card by cardId or throw an exception if not found
	    Card card = carddao.findById(cardId)
				.orElseThrow(() -> new IllegalArgumentException("Card with id: " + cardId+" not found."));
	 // Create a composite key (UserCollectionId) for the user and card
		UserCollectionId uid = new UserCollectionId(userId, cardId);

		// Try to find the existing entry in the user's collection
	    Optional<UserCollection> usercollection = dao.findById(uid);
	    
	    // If the card is already in the user's collection, increase the quantity
	    if (usercollection.isPresent()) {
	        UserCollection userCollection = usercollection.get();
	        userCollection.setQuantity(userCollection.getQuantity() + 1);
	        dao.save(userCollection);
	    } else {
	    	// If the card is not in the collection, create a new entry
	        UserCollection userCollection = new UserCollection();
	        userCollection.setId(uid);
	        userCollection.setUser(user);
	        userCollection.setCard(card);
	        userCollection.setQuantity(1);
	        dao.save(userCollection);
	    }
	}

	@Override
	public void removeCardToCollection(int userId, String cardId) {
		// Fetch the user by userId or throw an exception if not found
		User user = userDAO.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User with id: " + userId+" not found."));
		// Fetch the card by cardId or throw an exception if not found
		Card card = carddao.findById(cardId)
				.orElseThrow(() -> new IllegalArgumentException("Card with id: " + cardId+" not found."));
		// Create a composite key (UserCollectionId) for the user and card
		UserCollectionId cid = new UserCollectionId(userId, cardId);
		
		// Try to find the existing entry in the user's collection
		Optional<UserCollection> optionalUserCollection = dao.findById(cid);
		
		// If the card exists in the collection
		if (optionalUserCollection.isPresent()) {
			UserCollection userCollection = optionalUserCollection.get();
			// If the user has more than one of the card, reduce the quantity by 1
			if (userCollection.getQuantity() > 1) {
				userCollection.setQuantity(userCollection.getQuantity() - 1);
				dao.save(userCollection);
			} else {
				// If the quantity is 1 or less, remove the card from the collection
				dao.delete(userCollection);
			}
		} else {
			throw new RuntimeException("The card does not exist in the collection.");
		}
	}

	@Override
	public List<UserCollection> getUserCollection(int userId) {
		// Fetch the user by userId or throw an exception if not found
		User user = userDAO.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User with id: " + userId+" not found."));
		// Retrieve the user's collection from the database
			return dao.findByUser(user);
	}
}

