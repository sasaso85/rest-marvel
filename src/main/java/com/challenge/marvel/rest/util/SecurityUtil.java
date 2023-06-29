package com.challenge.marvel.rest.util;

import com.challenge.marvel.library.dto.CharacterRequestDto;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class SecurityUtil {
    public static CharacterRequestDto createSecurityRequest(String publicKey, String privateKey) {
        String timeStamp = UUID.randomUUID().toString();
        byte[] content = (timeStamp + privateKey + publicKey).getBytes();
        return CharacterRequestDto.builder()
                .apiKey(publicKey)
                .ts(timeStamp)
                .hash(DigestUtils.md5DigestAsHex(content))
                .build();
    }
}
