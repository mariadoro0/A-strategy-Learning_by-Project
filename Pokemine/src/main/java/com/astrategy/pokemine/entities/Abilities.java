package com.astrategy.pokemine.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter 
@Entity
@Table(name="abilities")
public class Abilities{
	@Id
	private int id ;
	private String name;
	private String text;
	private String type;

	@ManyToMany(mappedBy="abilities")
	@JsonBackReference
	private Set<Card> cards;

	

}
