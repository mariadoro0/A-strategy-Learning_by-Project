package com.astrategy.pokemine.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.services.CardService;
@RestController
@RequestMapping("pokemon")
public class CardController {
	@Autowired
	private CardService service;
	@GetMapping("Search")
	public ResponseEntity<List<Card>> getCard() {
		return new ResponseEntity<List<Card>>(service.getAllCards(),HttpStatus.OK);
	}
		
	@GetMapping("Search/id={id}")
	public ResponseEntity<Optional<Card>> getCardById(String id) {
		return new ResponseEntity<Optional<Card>>(service.getCardById(id),HttpStatus.OK);
	}	
	@GetMapping("Search/SetName={SetName}")
	public ResponseEntity<Optional<Card>> getCardBySetName(String set) {
		return new ResponseEntity<Optional<Card>>(service.getCardById(set),HttpStatus.OK);
	}	
	@GetMapping("Search/type={type}")
	public ResponseEntity<List<Card>> getCardByType_Id(int typeId) {
		return new ResponseEntity<List<Card>>(service.getCardByType_Id(typeId),HttpStatus.OK);
	}	
	@GetMapping("Search/generation={generation}")
	public ResponseEntity<List<Card>> getCardByGeneration(String generation) {
		return new ResponseEntity<List<Card>>(service.getCardByGeneration(generation),HttpStatus.OK);
	}	
	@GetMapping("Search/artist={artist}")
	public ResponseEntity<List<Card>> getCardByArtist(String artist) {
		return new ResponseEntity<List<Card>>(service.getCardByArtist(artist),HttpStatus.OK);
	}	
	@GetMapping("Search/rarity={rarity}")
	public ResponseEntity<List<Card>> getCardByRarity(String rarity) {
		return new ResponseEntity<List<Card>>(service.getCardByRarity(rarity),HttpStatus.OK);
	}	
	@GetMapping("Search/supertype={supertype}")
	public ResponseEntity<List<Card>> getCardBySupertype(String supertype) {
		return new ResponseEntity<List<Card>>(service.getCardBySupertype(supertype),HttpStatus.OK);
	}	
	@GetMapping("MultiSearch")
	public ResponseEntity<List<Card>> getCardByFilters(
			@RequestParam(required = false) String generation, 
			@RequestParam(required = false) String artist, 
			@RequestParam(required = false) String set, 
			@RequestParam(required = false) String rarity, 
			@RequestParam(required = false) String supertype, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer typeId) {
	      
		return new ResponseEntity<List<Card>>(service.getCardByGenerationByArtistBySetNameByRarityBySupertypeByType_Id(generation, artist, set, rarity, supertype, typeId, name),HttpStatus.OK);
	}	
	
		
	

}