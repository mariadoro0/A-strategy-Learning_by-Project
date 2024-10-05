package com.astrategy.pokemine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrategy.pokemine.entities.Users;
import com.astrategy.pokemine.repos.UsersDAO;


@Service
public class UsersServiceImpl implements UsersService{
	@Autowired 
	private UsersDAO dao; 
	
	
	@Override
	public void addUser(Users user) {
		dao.save(user);
		
	}

	@Override
	public List<Users> getByEmail(String email) {
		
		return dao.findbyemail(email);
	}

	@Override
	public void updateUser(Users user) {
		dao.updateUser(user);
		
	}

	
}
