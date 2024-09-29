package com.astrategy.pokemine.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
@Entity
@Table(name="abilities")
public class ability{

	private int id ;
	private String name;
	private String text;
	private String type;

	

}
