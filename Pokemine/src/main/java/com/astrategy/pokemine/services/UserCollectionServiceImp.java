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
	private UserDAO usrdao;
	@Autowired 
	private CardDAO carddao;

	@Override

	public void addCardToCollection(int userId, String cardId) {
	    User user = usrdao.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Utente con id: " + userId+" non trovato."));
	    Card card = carddao.findById(cardId)
				.orElseThrow(() -> new IllegalArgumentException("Carta con id: " + cardId+" non trovata."));
		UserCollectionId uid = new UserCollectionId(userId, cardId);

	    Optional<UserCollection> usercollection = dao.findById(uid);
	    if (usercollection.isPresent()) {
	        UserCollection userCollection = usercollection.get();
	        userCollection.setQuantity(userCollection.getQuantity() + 1);
	        dao.save(userCollection);
	    } else {
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
		User user = usrdao.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Utente con id: " + userId+" non trovato."));
		Card card = carddao.findById(cardId)
				.orElseThrow(() -> new IllegalArgumentException("Carta con id: " + cardId+" non trovata."));
		UserCollectionId cid = new UserCollectionId(userId, cardId);
		Optional<UserCollection> OuserCollection = dao.findById(cid);
		if (OuserCollection.isPresent()) {
			UserCollection userCollection = OuserCollection.get();
			if (userCollection.getQuantity() > 1) {
				userCollection.setQuantity(userCollection.getQuantity() - 1);
				dao.save(userCollection);
			} else {
				dao.delete(userCollection);
			}
		} else {
			throw new RuntimeException("La carta non esiste nella collezione.");
		}
	}

	@Override
	public List<UserCollection> getUserCollection(int userId) {
		User user = usrdao.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Utente con id: " + userId+" non trovato."));
			return dao.findByUser(user);
	}
}

