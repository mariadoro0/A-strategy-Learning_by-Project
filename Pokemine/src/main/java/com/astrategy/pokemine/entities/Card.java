package com.astrategy.pokemine.entities;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card {
	
	@Id
	private String id;
	
	private String set;
	
	private String series;
	
	private String publisher;
	
	private String generation;
	
	@Column(name="release_date")
	private String releasedate;
	
	private String artist ;
	
	private String name;

    /*set_num is set as a string because set_num is not always a number*/
    @Column(name="set_num")
	private String setNum;
	
	private String supertype;

    /*level is set as a String because few cards have level 'X'*/
	private String level;

    /*used Integer instead of int so it accepts NULL values*/
	private Integer hp;
	
	private String evolvesFrom;
	
	private String evolvesTo;
	
	private String retreatCost;
	
	private String convertedRetreatCost;
	
	private String rarity;
	
	private String flavorText;
	
	private String nationalPokedexNumbers;
	
	private String legalities;
	
	private String rules;
	
	private String regulationMark;
	
	private String ancientTrait;
	
	private String img;



}
