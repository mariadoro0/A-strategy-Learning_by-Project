package com.astrategy.pokemine.services;

import java.util.List;

import com.astrategy.pokemine.entities.Users;

public interface UsersService {

	
	void addUser(Users user);

	List<Users> getByEmail(String email);
	
	void updateUser(Users user);
}
