package com.challenge.marvel.rest.controller;

import com.challenge.marvel.rest.service.RegisterLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/log")
@RequiredArgsConstructor
public class RegisterLogController {

    private final RegisterLogService registerLogService;

    @GetMapping("/registers")
    public ResponseEntity<?> getRegisters() {
        return new ResponseEntity<>(registerLogService.getAll(), HttpStatus.OK);

    }

}
