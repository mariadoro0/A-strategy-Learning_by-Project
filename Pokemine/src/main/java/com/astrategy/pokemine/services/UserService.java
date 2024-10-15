package com.astrategy.pokemine.services;

import java.util.List;
import java.util.Optional;

import com.astrategy.pokemine.entities.User;

public interface UserService {

	
	void addUser(User user);

	User getByEmail(String email);
	
	void updateUser(User user);

	Optional<User> getUserById(int userId);
	
	void deleteById(int id);
}
