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
@Table(name="subtypes")

public class Subtypes {
	@Id
	private int id;
	private String name;

	@ManyToMany(mappedBy = "subtypes")
<<<<<<< HEAD
	@JsonBackReference
=======
	@JsonIgnore
>>>>>>> 8e52908 (modificato roba blalblala)
	private Set<Card> cards;

}
