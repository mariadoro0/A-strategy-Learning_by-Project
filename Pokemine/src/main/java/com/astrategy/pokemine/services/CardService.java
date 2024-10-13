package com.astrategy.pokemine.services;

import java.util.List;
import com.astrategy.pokemine.entities.Card;

public interface CardService {
    
    List<Card> getByFilters(String id, String name, String artist, String type, String setName, String generation, String rarity, String supertype, int page);
    
    Card getCardById(String id);
    
    List<Card> getCardByGeneration(String generation);
    
    List<Card> getCardByArtist(String artist);
    
    List<Card> getCardBySetName(String set);
    
    List<Card> getCardByRarity(String rarity);
    
    List<Card> getCardBySupertype(String supertype);
    
    List<Card> getCardByTypeId(int typeId);
    
    Card getCardByName(String name);
    
    List<Card> getAllCards();
    
    List<Card> getCardByFilters(String generation, String artist, String set, String rarity, String supertype, Integer typeId, String name);
}
