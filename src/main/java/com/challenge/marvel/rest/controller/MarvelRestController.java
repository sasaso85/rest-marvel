package com.challenge.marvel.rest.controller;

import com.challenge.marvel.rest.service.MarvelRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/marvel")
public class MarvelRestController {

    private final MarvelRestService marvelRestService;

    public MarvelRestController(MarvelRestService marvelRestService) {
        this.marvelRestService = marvelRestService;
    }

    @GetMapping("/characters")
    public ResponseEntity<?> getCharacters() {
        return new ResponseEntity<>(marvelRestService.getCharacters(), HttpStatus.OK);

    }
    @GetMapping("/characters/{id}")
    public ResponseEntity<?> getCharacterById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(marvelRestService.getCharacterById(id), HttpStatus.OK);

    }
}
