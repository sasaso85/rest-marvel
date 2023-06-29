package com.challenge.marvel.rest.service;

import com.challenge.marvel.rest.model.RegisterLog;
import com.challenge.marvel.rest.respository.RegisterLogRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegisterLogServiceImpl implements RegisterLogService{
    private final RegisterLogRepository repository;

    public RegisterLogServiceImpl(RegisterLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RegisterLog> getAll() {
        return repository.findAll();
    }

    @Override
    public RegisterLog saveRegister(RegisterLog register) {
        return repository.save(register);
    }
}
