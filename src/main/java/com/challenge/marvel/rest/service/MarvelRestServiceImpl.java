package com.challenge.marvel.rest.service;

import com.challenge.marvel.library.dto.CharacterDto;
import com.challenge.marvel.library.service.CharacterConsumerService;
import com.challenge.marvel.rest.util.RegisterLogUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarvelRestServiceImpl implements MarvelRestService {
    private final CharacterConsumerService characterConsumerService;
    private final SecurityService securityService;
    private final RegisterLogService registerLogService;

    @Override
    public List<CharacterDto> getCharacters() {
        List<CharacterDto> characterDtoList = characterConsumerService.getCharacters(securityService.createCharacterRequest(null));
        registerLogService.saveRegister(RegisterLogUtil.createRegister(200, "/characters"));
        return characterDtoList;
    }

    @Override
    public Optional<CharacterDto> getCharacterById(Long characterId) {
        Optional<CharacterDto> characterById = characterConsumerService.getCharacterById(securityService.createCharacterRequest(characterId));
        registerLogService.saveRegister(RegisterLogUtil.createRegister(200, "/characters/" + characterId));
        return characterById;
    }
}
