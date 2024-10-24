package com.astrategy.pokemine.services;

import java.util.List;
import java.util.Optional;

import com.astrategy.pokemine.dto.CardDTO;
import com.astrategy.pokemine.entities.Card;

public interface CardService {
        
	// Method to retrieve a list of cards based on various filters.
	CardDTO getByFilters(String Id, String name, String series, String artist, String type, String setName, String generation, String rarity, String supertype, int page);

}
