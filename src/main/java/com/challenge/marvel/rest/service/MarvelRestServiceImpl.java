package com.challenge.marvel.rest.service;

import com.challenge.marvel.library.dto.CharacterDto;
import com.challenge.marvel.library.service.CharacterConsumerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarvelRestServiceImpl implements MarvelRestService {
    private final CharacterConsumerService characterConsumerService;
    private final SecurityService securityService;

    public MarvelRestServiceImpl(CharacterConsumerService characterConsumerService, SecurityService securityService) {
        this.characterConsumerService = characterConsumerService;
        this.securityService = securityService;
    }

    @Override
    public List<CharacterDto> getCharacters() {
        return characterConsumerService.getCharacters(securityService.createCharacterRequest(null));
    }

    @Override
    public Optional<CharacterDto> getCharacterById(Long characterId) {
        return characterConsumerService.getCharacterById(securityService.createCharacterRequest(characterId));
    }
}
