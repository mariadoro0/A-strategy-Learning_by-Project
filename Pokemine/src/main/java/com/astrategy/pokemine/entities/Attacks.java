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
@Table(name="attacks")

public class Attacks {
	
	
	@Id
	private int id;
	private String attackName;
	private String cost;
	private String damage;
	private int convertedEnergyCost;
	private String text;

	// Bidirectional Many-to-Many relationship with the `Card` entity
	@ManyToMany(mappedBy="attacks")
	@JsonBackReference   // Prevents infinite recursion during JSON serialization
	private Set<Card> cards;



}
