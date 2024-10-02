package com.astrategy.pokemine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	private String username;
	private String email;
	private String password;
	
	public Users(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@OneToMany(mappedBy = "users")
	@JsonIgnore
	private UserCollection usersCollection ;




}
