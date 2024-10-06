package com.astrategy.pokemine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.repos.UserDAO;


@Service
public class UsersServiceImpl implements UsersService{
	@Autowired 
	private UserDAO dao;
	
	
	@Override
	public void addUser(User user) {
		dao.save(user);
		
	}

	@Override
	public List<User> getByEmail(String email) {
		
		return dao.findbyemail(email);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
		
	}

	
}
