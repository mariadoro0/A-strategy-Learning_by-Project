package com.astrategy.pokemine.entities;


<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> 8e52908 (modificato roba blalblala)
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
//	@JsonIgnore
	private Set<Card> cards;
	

}
