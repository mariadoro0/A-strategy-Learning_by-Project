package com.astrategy.pokemine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="subtypes")

public class Subtypes {
	
	private int id;
	private String name;

}
