package com.astrategy.pokemine.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private String damage; //damage type is string in database

	private int convertedEnergyCost;
	private String text;


	@ManyToMany(mappedBy="attacks")
	@JsonBackReference
//	@JsonIgnore
	private Set<Card> cards;



}
