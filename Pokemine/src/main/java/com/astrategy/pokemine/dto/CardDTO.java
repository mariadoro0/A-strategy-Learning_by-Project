package com.astrategy.pokemine.dto;

import com.astrategy.pokemine.entities.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
// Data Transfer Object to have better visualization of the page:
// this shows the list of cards, the current page we're on, the number of total pages and the total number of items
public class CardDTO {
    private List<Card> cards;
    private int currentPage;
    private int totPages;
    private int totalCards;
}
