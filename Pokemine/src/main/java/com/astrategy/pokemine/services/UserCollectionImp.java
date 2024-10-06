package com.astrategy.pokemine.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.entities.UserCollectionId;
import com.astrategy.pokemine.entities.UserCollection;
import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.repos.CardDAO;
import com.astrategy.pokemine.repos.UserCollectionDAO;
import com.astrategy.pokemine.repos.UserDAO;

public class UserCollectionImp implements UserCollectionService {

	@Autowired
	private UserCollectionDAO dao;
	@Autowired 
	private UserDAO usrdao;
	@Autowired CardDAO carddao;
	@Override
	public void addCardToColletion(UserCollectionId cid) {
		// TODO Auto-generated method stub
		Optional<UserCollection> usercollection = dao.findById(cid);
		if (usercollection.isPresent()) {
			UserCollection userCollection = usercollection.get();
			userCollection.setQuantity(userCollection.getQuantity()+1);
			dao.save(userCollection);
		}else {
			User user = usrdao.findById(cid.getUserId()).orElse(null);
			Card card = carddao.findById(cid.getCardId()).orElse(null);
			
			if (user == null || card == null ) {
				throw new IllegalArgumentException("Utente o carta non trovati");}
			
			UserCollection userCollection = new UserCollection();
			userCollection.setId(uid);
			userCollection.setUser(user); //setta l'utenete
			userCollection.setCard(card); //setta la carta
			userCollection.setQuantity(1); // setta quantità a uno
			dao.save(userCollection);
		}
	}

	@Override
	public void removeCardToColletion(UserCollectionId Cid) {
		// TODO Auto-generated method stub
		Optional<UserCollection> OuserCollection = dao.findById(cid);
		if(OuserCollection.isPresent()) {
			UserCollection userCollection = OuserCollection.get();
			if(userCollection.getQuantity()> 1) {
				userCollection.setQuantity(userCollection.getQuantity()-1);
				dao.save(userCollection);
			}else {
				dao.delete(userCollection);
			}
		}else {
			throw new RuntimeException("La carta non esiste nella collezione.");
		}
		
	}

	@Override
	public UserCollection getUserCollection(int UserId) {
		// TODO Auto-generated method stub
		return dao.findByUserId(usrdao.findById(UserId));
	}

}
