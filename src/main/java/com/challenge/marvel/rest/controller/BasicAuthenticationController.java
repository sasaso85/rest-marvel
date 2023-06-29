package com.challenge.marvel.rest.controller;

import com.challenge.marvel.rest.dto.AuthenticationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BasicAuthenticationController {
    @GetMapping(path = "/basicauth")
    public AuthenticationDto basicAuth() {
        return new AuthenticationDto("You are authenticated");
    }

}
