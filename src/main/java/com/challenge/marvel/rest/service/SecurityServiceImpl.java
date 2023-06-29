package com.challenge.marvel.rest.service;

import com.challenge.marvel.library.dto.CharacterRequestDto;
import com.challenge.marvel.rest.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@PropertySource("classpath:keys.properties")
public class SecurityServiceImpl implements SecurityService {

    private final Map<String, String> keys;

    public SecurityServiceImpl(@Value("#{${api.keys}}") Map<String, String> keys) {
        this.keys = keys;
    }

    @Override
    public CharacterRequestDto createCharacterRequest(Long characterId) {
        CharacterRequestDto request = SecurityUtil.createSecurityRequest(keys.get("public"), keys.get("private"));
        if (characterId != null) {
            request.setCharacterId(characterId);
        }
        request.setLimit("20");
        request.setOffset("0");
        return request;
    }
}
