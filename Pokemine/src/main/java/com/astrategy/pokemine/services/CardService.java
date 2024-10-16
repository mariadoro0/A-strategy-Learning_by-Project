package com.astrategy.pokemine.services;

import java.util.List;
import java.util.Optional;

import com.astrategy.pokemine.entities.Card;

public interface CardService {
        List<Card> getByFilters(String Id, String name, String series,String artist, String type, String setName, String generation, String rarity, String supertype, int page);
        Optional<Card> getCardById(String id);
        List<Card> getAllCards();
}
