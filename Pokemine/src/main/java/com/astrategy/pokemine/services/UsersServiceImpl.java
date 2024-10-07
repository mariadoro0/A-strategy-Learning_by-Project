package com.astrategy.pokemine.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.repos.UserDAO;


@Service
public class UsersServiceImpl implements UsersService{
	@Autowired 
	private UserDAO dao; 

	
	
	
	@Autowired 
	private UsersService service;
	

	@Override
	public void addUser(User user) {
		
		boolean existingUserByEmail = dao.existsByEmail(user.getEmail());
		if(existingUserByEmail) {
			throw new RuntimeException("Un utente esiste già con questa email");
		}
		
		boolean existingUserByUsername = dao.existsByUsername(user.getUsername());
		if(existingUserByUsername) {
			throw new RuntimeException("Un utente esiste già con questa email");
		}
		
		dao.save(user);
		
	}

	@Override
	public User getByEmail(String email) {
		
		return dao.findbyemail(email);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
		
	}

	
}
