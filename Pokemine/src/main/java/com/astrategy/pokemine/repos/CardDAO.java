package com.astrategy.pokemine.repos;

import com.astrategy.pokemine.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardDAO extends JpaRepository<Card, String>, JpaSpecificationExecutor<Card> {
    Optional<Card> findById(String Id);
    List<Card> findByGeneration(String generation);
    List<Card> findByArtist(String artist);
    List<Card> findBySetName(String set);
    List<Card> findByRarity(String rarity);
    List<Card> findBySupertype(String supertype);
    List<Card> findByTypes_Id(int typeId);
    Card findByName(String name);


}
