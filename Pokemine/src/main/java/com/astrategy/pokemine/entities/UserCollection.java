package com.astrategy.pokemine.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="user_collection")
public class UserCollection {

	@EmbeddedId
	private CollectionKeys id;
	private int quantity ;
	
	
}
