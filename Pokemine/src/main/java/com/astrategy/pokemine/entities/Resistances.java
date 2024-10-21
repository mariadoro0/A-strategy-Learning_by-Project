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
@Table (name="resistances")

public class Resistances {
	@Id
	private int id;
	private String type;
	private String value;

	// Many-to-Many relationship with the Card entity. Each resistance can be associated with multiple cards, and each card can have multiple resistances.
	@ManyToMany(mappedBy="resistances")
	@JsonBackReference   // Prevents cyclic references in bidirectional relationships when serializing to JSON.
	private Set<Card> cards;

}
