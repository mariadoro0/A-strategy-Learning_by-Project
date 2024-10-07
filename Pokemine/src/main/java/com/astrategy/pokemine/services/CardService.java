package com.astrategy.pokemine.services;

import java.util.List;
import java.util.Optional;

import com.astrategy.pokemine.entities.Card;

public interface CardService {
	
        Optional<Card> getCardById(String id);
        List<Card> getCardByGeneration(String generation);
        List<Card> getCardByArtist(String artist);
        List<Card> getCardBySetName(String set);
        List<Card> getCardByRarity(String rarity);
        List<Card> getCardBySupertype(String supertype);
        List<Card> getCardByType_Id(int typeId);
        Card getCardByName(String name);
        List<Card> getAllCards();
        List<Card> getCardByGenerationByArtistBySetNameByRarityBySupertypeByType_Id(String generation, String artist, String set, String rarity, String supertype, Integer typeId, String name);
		Card getCard(String cardId);
}
