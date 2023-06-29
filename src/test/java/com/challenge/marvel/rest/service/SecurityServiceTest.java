package com.challenge.marvel.rest.service;

import com.challenge.marvel.library.dto.CharacterRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.DigestUtils;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SecurityServiceTest {
    @InjectMocks
    private SecurityServiceImpl securityService;

    @Mock
    private Map<String, String> keys;

    @Test
    @DisplayName("JUnit test for getCharacterById method return Character")
    public void givenId_whenGetCharacters_thenReturnCharacter() {
        // given
        given(keys.get("public")).willReturn("publicKey");
        given(keys.get("private")).willReturn("privateKey");
        // when
        CharacterRequestDto request = securityService.createCharacterRequest(1234L);
        // then
        String content = request.getTs() + "privateKey" + request.getApiKey();
        assertThat(request).isNotNull();
        assertThat(request.getHash()).isEqualTo(DigestUtils.md5DigestAsHex(content.getBytes()));
    }
}
