package com.astrategy.pokemine.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.astrategy.pokemine.entities.User;

public interface UserService {

	
	void addUser(User user);

	User getByEmail(String email);

	User findByUsername(String username);


	Optional<User> getUserById(int userId);
	
	void deleteById(int id);

	boolean checkAuthorization(int userId, Principal p);
}
