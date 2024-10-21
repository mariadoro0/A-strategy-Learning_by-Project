package com.astrategy.pokemine.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrategy.pokemine.entities.User;
import com.astrategy.pokemine.repos.UserDAO;


@Service
public class UsersServiceImpl implements UserService, UserDetailsService {
	@Autowired 
	private UserDAO dao; 

	
	
	
	@Autowired 
	private UserService service;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    Optional<UserEntity> user= Optional.of(dao.findByUsername(username));
    if(user.isPresent()){
      var userd = user.get();
      return User.builder()
                 .username(userd.getUsername())
                 .password(userd.getPassword())
                 .roles("USER")
                 .build();
    }
    else{
      throw new UsernameNotFoundException(username);
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

	@Override
	public User getByEmail(String email) {
		
		return dao.findByEmail(email);
	}

	@Override
	public Optional<User> getUserById(int userId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	

	
}
