package com.astrategy.pokemine.repos;

import com.astrategy.pokemine.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDAO extends JpaRepository<Card, String> {
    List<Card> findByGeneration(String generation);
    List<Card> findByArtist(String artist);
    List<Card> findBySetName(String set);
    List<Card> findByRarity(String rarity);
    List<Card> findBySupertype(String supertype);
    List<Card> findByTypes_Id(int typeId);


}
