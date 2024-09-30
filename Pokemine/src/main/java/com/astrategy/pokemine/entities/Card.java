package com.astrategy.pokemine.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
	
	private int setnum;
	
	private String supertype;
	
	private int level;
	
	private int hp;
	
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
