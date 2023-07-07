package com.challenge.marvel.rest.controller;

import com.challenge.marvel.rest.dto.AuthenticationDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "${origin.path}")
@RestController
@RequestMapping("${authentication.base.path}")
public class BasicAuthenticationController {
    @GetMapping()
    public AuthenticationDto basicAuth() {
        return new AuthenticationDto("You are authenticated");
    }

}
