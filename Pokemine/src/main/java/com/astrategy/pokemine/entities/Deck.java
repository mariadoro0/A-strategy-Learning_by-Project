package com.astrategy.pokemine.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "decks")
public class Deck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deck_id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	private String deckName;
	
	private String deckDescription;

	@OneToMany(mappedBy = "deck")
	private Set<DeckCard> deckCards;

	public Deck(User userId, String deckName, String deckDescription) {
		this.user = userId;
		this.deckName = deckName;
		this.deckDescription = deckDescription;
		this.deckCards = new LinkedHashSet<>();
	}


	public Deck() {

	}
}
