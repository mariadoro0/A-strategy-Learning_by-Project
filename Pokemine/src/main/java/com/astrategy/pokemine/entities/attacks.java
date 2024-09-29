package com.astrategy.pokemine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="attacks")

public class attacks {
	
	
	
	private int id;
	private String attack_name;
	private String cost;
	private int damage;
	private int convertedEnergyCost;
	private String text;

	

}
