package com.astrategy.pokemine.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Getter
@Setter
@Entity
@Table(name ="user_collection")
public class UserCollection {

	@EmbeddedId
	private UserCollectionId id;
	
	@ManyToOne
	@MapsId("cardId")
	@JoinColumn(name="card_id")
	@JsonIgnore
	private Card cards ;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name="user_id")
	@JsonIgnore

	private User user;

	@Column(name ="quantity")
	private int quantity ;



}
