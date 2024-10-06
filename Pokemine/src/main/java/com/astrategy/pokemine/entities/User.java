package com.astrategy.pokemine.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	private String username;
	private String email;
	private String password; //dobbiamo fare il getter di password ?
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;     //Ma PPPPPPERCHE IL COSTRUTTORE ?
		this.password = password;
	}

	@OneToMany(mappedBy = "user")
	private Set<UserCollection> usersCollection ;




}
