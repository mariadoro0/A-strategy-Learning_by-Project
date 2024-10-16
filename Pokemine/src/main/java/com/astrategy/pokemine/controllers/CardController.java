package com.astrategy.pokemine.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.astrategy.pokemine.entities.Types;
import com.astrategy.pokemine.repos.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.services.CardService;
@RestController
@RequestMapping("cards")
public class CardController {
	@Autowired
	private CardService service;

	@Autowired
	private TypeDAO dao;

	@Async
	@GetMapping("search")
	public CompletableFuture<ResponseEntity<List<Card>>> getCards() {
		return CompletableFuture.supplyAsync(() -> {
			List<Card> cards = service.getAllCards();
			return new ResponseEntity<>(cards,HttpStatus.OK);
			//return new ResponseEntity<List<Card>>(service.getAllCards(),HttpStatus.OK);
		});
		//return new ResponseEntity<List<Card>>(service.getAllCards(),HttpStatus.OK);
	}
		
	@GetMapping("search/id={id}")
	public ResponseEntity<Card> getCardById(@PathVariable String id) {
		return new ResponseEntity<Card>(service.getCardById(id),HttpStatus.OK);
	}	
	@GetMapping("search/SetName={set}")
	public ResponseEntity<List<Card>> getCardBySetName(@PathVariable String set) {
		return new ResponseEntity<List<Card>>(service.getCardBySetName(set),HttpStatus.OK);
	}
	@Async
	@GetMapping("search/type={typeId}")
	public CompletableFuture<ResponseEntity<List<Card>>> getCardByType_Id(@PathVariable String typeId) {
		//Types types = dao.findByName(typeId);
		Types types = dao.findByName(typeId);
		//return CompletableFuture.supplyAsync(()-> ResponseEntity<List<Card>>(service.getCardByType_Id(types.getId()),HttpStatus.OK));
		return CompletableFuture.supplyAsync(() -> {
			// Find the type based on the provided typeId


			// Handle null case where no type is found
			if (types == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			// Fetch the cards based on the type id
			//List<Card> cards = ;
			return new ResponseEntity<List<Card>>(service.getCardByType_Id(types.getId()), HttpStatus.OK);
		});
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
			@RequestParam(required = false) String id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String series,
			@RequestParam(required = false) String artist,
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String set,
			@RequestParam(required = false) String generation,
			@RequestParam(required = false) String rarity, 
			@RequestParam(required = false) String supertype,
			@RequestParam(required = false, defaultValue = "1") int page
			) {
	      
		return new ResponseEntity<List<Card>>(service.getByFilters(id,name, series, artist, type, set, generation, rarity, supertype, page),HttpStatus.OK);
	}	
	
		
	

}
