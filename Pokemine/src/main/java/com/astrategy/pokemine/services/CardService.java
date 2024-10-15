package com.astrategy.pokemine.services;

import java.util.List;
import com.astrategy.pokemine.entities.Card;

public interface CardService {
        List<Card> getCardByFilters(String generation, String artist, String set, String rarity, String supertype, Integer typeId, String name);
        Card getCardById(String id);
        List<Card> getAllCards();
}
