package com.astrategy.pokemine.services;

import java.util.List;

import com.astrategy.pokemine.entities.User;

public interface UsersService {

	
	void addUser(User user);

	User getByEmail(String email);
	
	//void updateUser(User user);
}
