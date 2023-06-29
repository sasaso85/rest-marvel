package com.challenge.marvel.rest.service;

import com.challenge.marvel.library.dto.CharacterRequestDto;

public interface SecurityService {
    CharacterRequestDto createCharacterRequest(Long characterId);
}