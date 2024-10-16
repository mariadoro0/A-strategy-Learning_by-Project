package com.astrategy.pokemine.entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
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
	private Integer id;
	private String name;
	@ManyToMany(mappedBy="types")
	@JsonBackReference
	private Set<Card> cards;
	

}
