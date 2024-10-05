package com.astrategy.pokemine.services;

import java.util.List;

import com.astrategy.pokemine.entities.Users;

public interface UsersService {

	
	void addUser(Users user);
	
	List<Users> getbyemail(String email);
	
	void getupdateUser(Users user);
}
