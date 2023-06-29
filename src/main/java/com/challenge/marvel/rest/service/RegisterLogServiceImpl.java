package com.challenge.marvel.rest.service;

import com.challenge.marvel.rest.model.RegisterLog;
import com.challenge.marvel.rest.respository.RegisterLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegisterLogServiceImpl implements RegisterLogService{
    private final RegisterLogRepository repository;
    @Override
    public List<RegisterLog> getAll() {
        return repository.findAll();
    }

    @Override
    public RegisterLog saveRegister(RegisterLog register) {
        return repository.save(register);
    }
}
