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
	private int deck_id;
	
	private int user_id;
	
	private String deck_name;
	
	private String deck_description;
	
}
