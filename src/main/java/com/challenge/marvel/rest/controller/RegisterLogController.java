package com.challenge.marvel.rest.controller;

import com.challenge.marvel.rest.service.RegisterLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "${origin.path}")
@RestController
@RequestMapping("${log.base.path}")
@RequiredArgsConstructor
public class RegisterLogController {

    private final RegisterLogService registerLogService;

    @GetMapping()
    public ResponseEntity<?> getRegisters() {
        return new ResponseEntity<>(registerLogService.getAll(), HttpStatus.OK);

    }

}
