package com.challenge.marvel.rest.controller;

import com.challenge.marvel.rest.service.MarvelRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/marvel")
@RequiredArgsConstructor
public class MarvelRestController {

    private final MarvelRestService marvelRestService;

    @GetMapping("/characters")
    public ResponseEntity<?> getCharacters() {
        return new ResponseEntity<>(marvelRestService.getCharacters(), HttpStatus.OK);

    }
    @GetMapping("/characters/{id}")
    public ResponseEntity<?> getCharacterById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(marvelRestService.getCharacterById(id), HttpStatus.OK);

    }
}
