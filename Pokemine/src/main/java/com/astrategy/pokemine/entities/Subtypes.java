package com.astrategy.pokemine.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="subtypes")

public class Subtypes {
	@Id
	private int id;
	private String name;
	
	// Many-to-Many relationship with the Card entity. Each subtype can be associated with multiple cards, and each card can have multiple subtypes.
	@ManyToMany(mappedBy = "subtypes")
	@JsonBackReference  // Prevents cyclic references during JSON serialization for the bidirectional relationship.
	private Set<Card> cards;

}
