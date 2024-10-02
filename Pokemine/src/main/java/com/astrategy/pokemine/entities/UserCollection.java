package com.astrategy.pokemine.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="user_collection")
public class UserCollection {

	@EmbeddedId
	private CollectionId id;
	
	@ManyToOne
	@JoinColumn(name="cardId")
	private Card cards ;
	@ManyToOne
	@JoinColumn(name="userId")
	private Users users;
	
	
	private int quantity ;
	
	
}
