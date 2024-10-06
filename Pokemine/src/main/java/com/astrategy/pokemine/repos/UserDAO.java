package com.astrategy.pokemine.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.astrategy.pokemine.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	
	//Create
	//void addUser(Users user);
	
	//Read
	
	List<User> findbyemail(String email);
	//findbyname
	
	//update
	void updateUser(User user);
	
	
	//delete
	//void deleteById(ID id);	
	
	
	
}
