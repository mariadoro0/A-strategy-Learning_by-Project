package com.astrategy.pokemine.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.repos.UserDAO;


@Service
public class UsersServiceImpl implements UserService, UserDetailsService {
	@Autowired 
	private UserDAO dao;
  
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user= Optional.of(dao.findByEmail(email));
    if(user.isPresent()){
      var userd = user.get();
      return org.springframework.security.core.userdetails.User.builder()
                 .username(userd.getUsername())
                 .password(userd.getPassword())
                 .roles("USER")
                 .build();
    }
    else{
      throw new UsernameNotFoundException(email);
    }
    
  }
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
	

	// Method to retrieve a user by their email address
	@Override
	public User getByEmail(String email) {
		
		return dao.findByEmail(email);
	}

	// Method to retrieve a user by their ID
	@Override
	public Optional<User> getUserById(int userId) {
		return dao.findById(userId);
	}



	// Method to delete a user by their ID, with a check if the user exists
	@Override
	public void deleteById(int id) {
		
		 Optional<User> existingUser = dao.findById(id);
		    
		   if (existingUser.isEmpty()) {
		       
		        throw new RuntimeException("L'utente non esiste e non può essere cancellato");
		        
		    }

		   dao.deleteById(id);
	}

	

	
}
