package com.challenge.marvel.rest.service;

import com.challenge.marvel.library.dto.CharacterDto;
import com.challenge.marvel.library.dto.CharacterRequestDto;
import com.challenge.marvel.library.service.CharacterConsumerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MarvelRestServiceTest {

    @Mock
    private CharacterConsumerService characterConsumerService;

    @Mock
    private SecurityService securityService;

    @InjectMocks
    private MarvelRestServiceImpl marvelRestService;


    private CharacterRequestDto request;

    private CharacterDto character;


    public static final String RESPONSE =
            "{\"id\":1011334,\"name\":\"3-D Man\"," +
                    "\"description\":\"\",\"thumbnail\":{" +
                    "\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784\"," +
                    "\"extension\":\"jpg\"" +
                    "}}";

    @BeforeEach
    public void setup() {
        request = CharacterRequestDto.builder()
                .apiKey("publicKey")
                .ts("timestamp")
                .hash("hash")
                .limit("1")
                .offset("0")
                .build();
        try {
            character = new ObjectMapper().readValue(RESPONSE, CharacterDto.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("JUnit test for getCharacters method return Character List")
    public void givenCharacterList_whenGetCharacters_thenReturnCharacterList() {
        // given
        List<CharacterDto> listResponse = new ArrayList<>();
        listResponse.add(character);
        given(securityService.createCharacterRequest(null)).willReturn(request);
        given(characterConsumerService.getCharacters(request)).willReturn(listResponse);
        // when
        List<CharacterDto> characterList = marvelRestService.getCharacters();
        // then
        assertThat(characterList).isNotNull();
        assertThat(characterList.size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("JUnit test for getCharacterById method return Character")
    public void givenId_whenGetCharacters_thenReturnCharacter() {
        // given
        request.setCharacterId(1234L);
        given(securityService.createCharacterRequest(1234L)).willReturn(request);
        given(characterConsumerService.getCharacterById(request)).willReturn(Optional.of(character));
        // when
        Optional<CharacterDto> characterList = marvelRestService.getCharacterById(1234L);
        // then
        assertThat(characterList).isNotNull();
        assertThat(characterList.isPresent()).isTrue();
    }

}
