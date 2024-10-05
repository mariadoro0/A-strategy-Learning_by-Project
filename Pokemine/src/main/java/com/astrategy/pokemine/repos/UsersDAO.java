package com.astrategy.pokemine.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.astrategy.pokemine.entities.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer>{
	
	//Create
	//void addUser(Users user);
	
	//Read
	
	List<Users> findbyemail(String email);
	//findbyname
	
	//update
	void updateUser(Users user);
	
	
	//delete
	//void deleteById(ID id);	
	
	
	
}
