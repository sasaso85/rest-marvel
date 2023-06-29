package com.challenge.marvel.rest;

import com.challenge.marvel.library.service.CharacterConsumerService;
import com.challenge.marvel.library.service.CharacterConsumerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarvelRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelRestApplication.class, args);
	}

	@Bean
	public CharacterConsumerService characterConsumerService(RestTemplateBuilder builder) {
		return new CharacterConsumerServiceImpl(builder.build());
	}
}
