package com.astrategy.pokemine.services;

import java.util.List;

import com.astrategy.pokemine.entities.Card;

public interface CardService {
	
        List<Card> getCardById(String id);
        List<Card> getCardByGeneration(String generation);
        List<Card> getCardByArtist(String artist);
        List<Card> getCardBySetName(String set);
        List<Card> getCardByRarity(String rarity);
        List<Card> getCardBySupertype(String supertype);
        List<Card> getCardByType_Id(int typeId);

        List<Card> getCardByGenerationByArtistBySetNameByRarityBySupertypeByType_Id(
        String generation,
        String artist,
        String set,
        String rarity,
        String supertype,
        String typeId);
}
