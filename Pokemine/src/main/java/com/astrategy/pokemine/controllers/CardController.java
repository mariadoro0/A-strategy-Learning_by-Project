package com.astrategy.pokemine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.astrategy.pokemine.entities.Card;
import com.astrategy.pokemine.services.CardService;
@RestController
@RequestMapping("cards")
public class CardController {
	@Autowired
	private CardService service;
	@GetMapping("/")
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