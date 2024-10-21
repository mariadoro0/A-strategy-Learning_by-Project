package com.astrategy.pokemine.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="types")
public class Types {
	@Id
	private Integer id;
	private String name;
	
	 // Many-to-Many relationship with the Card entity. Each type can apply to multiple cards, and each card can have multiple types.
	@ManyToMany(mappedBy="types")
	@JsonBackReference  // Prevents cyclic references during JSON serialization for the bidirectional relationship.
	private Set<Card> cards;
	

}
