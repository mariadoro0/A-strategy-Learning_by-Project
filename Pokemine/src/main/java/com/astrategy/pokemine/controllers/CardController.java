package com.astrategy.pokemine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.services.CardService;
@RestController
@RequestMapping("pokemon")
public class CardController {
	@Autowired
	private CardService service;
	@GetMapping("search")
	public ResponseEntity<List<Card>> getCard() {
		return new ResponseEntity<List<Card>>(service.getAllCards(),HttpStatus.OK);
	}
		
	@GetMapping("search/id={id}")
	public ResponseEntity<Card> getCardById(@PathVariable String id) {
		return new ResponseEntity<Card>(service.getCardById(id),HttpStatus.OK);
	}	
	@GetMapping("search/SetName={set}")
	public ResponseEntity<List<Card>> getCardBySetName(@PathVariable String set) {
		return new ResponseEntity<List<Card>>(service.getCardBySetName(set),HttpStatus.OK);
	}	
	@GetMapping("search/type={typeId}")
	public ResponseEntity<List<Card>> getCardByType_Id(@PathVariable int typeId) {
		return new ResponseEntity<List<Card>>(service.getCardByType_Id(typeId),HttpStatus.OK);
	}	
	@GetMapping("search/generation={generation}")
	public ResponseEntity<List<Card>> getCardByGeneration(@PathVariable String generation) {
		return new ResponseEntity<List<Card>>(service.getCardByGeneration(generation),HttpStatus.OK);
	}	
	@GetMapping("search/artist={artist}")
	public ResponseEntity<List<Card>> getCardByArtist(@PathVariable String artist) {
		return new ResponseEntity<List<Card>>(service.getCardByArtist(artist),HttpStatus.OK);
	}	
	@GetMapping("search/rarity={rarity}")
	public ResponseEntity<List<Card>> getCardByRarity(@PathVariable String rarity) {
		return new ResponseEntity<List<Card>>(service.getCardByRarity(rarity),HttpStatus.OK);
	}	
	@GetMapping("search/supertype={supertype}")
	public ResponseEntity<List<Card>> getCardBySupertype(@PathVariable String supertype) {
		return new ResponseEntity<List<Card>>(service.getCardBySupertype(supertype),HttpStatus.OK);
	}	
	@GetMapping("multisearch")
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