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
@Table(name="weaknesses")
public class Weaknesses {
	@Id
	private int id;
	private String type;
	private String value;
	
	 // Defines a many-to-many relationship with the Card entity.
	@ManyToMany(mappedBy="weaknesses")
	@JsonBackReference // Prevents circular references during JSON serialization.
	private Set<Card> cards; // A set of cards that have this weakness.


}
