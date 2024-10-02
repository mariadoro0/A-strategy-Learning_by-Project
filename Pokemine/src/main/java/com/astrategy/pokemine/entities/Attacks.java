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
@Table(name="attacks")

public class Attacks {
	
	
	@Id
	private int id;
	private String attackName;
	private String cost;
	private int damage;
	private int convertedEnergyCost;
	private String text;


	@ManyToMany(mappedBy="attacks")
	private Set<Card> cards;



}
