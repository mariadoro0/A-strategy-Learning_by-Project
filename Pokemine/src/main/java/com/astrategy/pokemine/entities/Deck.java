package com.astrategy.pokemine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "decks")
public class Deck {
	
	@Id
	private int deckId;
	
	private int userId;
	
	private String deckName;
	
	private String deckDescription;

	public Deck(int userId, String deckName, String deckDescription) {
		this.userId = userId;
		this.deckName = deckName;
		this.deckDescription = deckDescription;
	}
	
	
	
}
