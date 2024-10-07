package com.astrategy.pokemine.services;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.repos.CardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardDAO dao;

    @Override
    public Optional<Card> getCardById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Card> getCardByGeneration(String generation) {
        return dao.findByGeneration(generation);
    }

    @Override
    public List<Card> getCardByArtist(String artist) {
        return dao.findByArtist(artist);
    }

    @Override
    public List<Card> getCardBySetName(String set) {
        return dao.findBySetName(set);
    }

    @Override
    public List<Card> getCardByRarity(String rarity) {
        return dao.findByRarity(rarity);
    }

    @Override
    public List<Card> getCardBySupertype(String supertype) {
        return dao.findBySupertype(supertype);
    }

    @Override
    public List<Card> getCardByType_Id(int typeId) {
        return dao.findByTypes_Id(typeId);
    }

    @Override
    public List<Card> getCardByGenerationByArtistBySetNameByRarityBySupertypeByType_Id(String generation, String artist, String set, String rarity, String supertype, Integer typeId, String name) {
        return dao.findAll().stream()
                .filter(card -> generation == null || generation.isEmpty() || card.getGeneration().equals(generation))
                .filter(card -> artist == null || artist.isEmpty() || card.getArtist().equals(artist))
                .filter(card -> set == null || set.isEmpty() || card.getSetName().equals(set))
                .filter(card -> rarity == null || rarity.isEmpty() || card.getRarity().equals(rarity))
                .filter(card -> supertype == null || supertype.isEmpty() || card.getSupertype().equals(supertype))
                .filter(card -> typeId == null || card.getTypes().stream().anyMatch(type -> type.getId().equals(typeId)))
                .filter(card -> name == null || name.isEmpty()||card.getName().equals(name))
                .collect(Collectors.toList());
    }

	public List<Card> getAllCards() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Card getCardByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}
}
