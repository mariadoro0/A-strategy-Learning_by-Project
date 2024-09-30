package com.astrategy.pokemine.entities;

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

	@ManyToMany(mappedBy="resistances")
	private Set<Card> cards;
}
