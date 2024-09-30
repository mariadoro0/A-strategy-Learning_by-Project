package com.astrategy.pokemine.entities;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="types")
public class Types {
	@Id
	private int id;
	private String name;
	@ManyToMany(mappedBy="types")
	private Set<Card> cards;
	

}
