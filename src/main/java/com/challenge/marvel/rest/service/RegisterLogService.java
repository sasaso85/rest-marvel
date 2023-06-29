package com.challenge.marvel.rest.service;

import com.challenge.marvel.rest.model.RegisterLog;

import java.util.List;

public interface RegisterLogService {
    List<RegisterLog> getAll();

    RegisterLog saveRegister(RegisterLog register);
}
