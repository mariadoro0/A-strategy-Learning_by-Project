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
@Table(name="abilities")
public class Abilities{
	@Id
	private int id ;
	private String name;
	private String text;
	private String type;

	@ManyToMany(mappedBy="abilities")

	@JsonBackReference
//	@JsonIgnore
	private Set<Card> cards;

	

}
