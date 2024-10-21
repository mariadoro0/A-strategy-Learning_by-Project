package com.astrategy.pokemine.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter 
@Entity
@Table(name="abilities")
public class Abilities{
	@Id
	private int id ;
	private String name;
	private String text;
	private String type;
	
	// Bidirectional Many-to-Many relationship with the `Card` entity
	@ManyToMany(mappedBy="abilities")
	@JsonBackReference     // Prevents infinite recursion during JSON serialization
	private Set<Card> cards;

	

}
