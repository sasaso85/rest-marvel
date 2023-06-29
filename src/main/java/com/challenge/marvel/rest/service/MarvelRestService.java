package com.challenge.marvel.rest.service;

import com.challenge.marvel.library.dto.CharacterDto;

import java.util.List;
import java.util.Optional;

public interface MarvelRestService {
    List<CharacterDto> getCharacters();

    Optional<CharacterDto> getCharacterById(Long characterId);
}
