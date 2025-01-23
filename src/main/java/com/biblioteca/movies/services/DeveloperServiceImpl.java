package com.biblioteca.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.biblioteca.movies.domain.Developer;
import com.biblioteca.movies.repositories.DeveloperRespository;
import com.biblioteca.movies.services.contracts.DeveloperService;

public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRespository respository;
    
    @Autowired
    public DeveloperServiceImpl(DeveloperRespository respository) {
        this.respository = respository;
    }

    @Override
    public Optional<Developer> findById(Long id) {
        return respository.findById(id);
    }

    @Override
    public List<Developer> findAll() {
        return respository.findAll();
    }

    @Override
    public Developer create(Developer entity) {
        return respository.saveAndFlush(entity);
    }

    @Override
    public Developer update(Developer entity) {
        return respository.saveAndFlush(entity);
    }

    @Override
    public Developer delete(Long id) {
        Developer dev = findById(id).get();
        respository.delete(dev);
        return dev;
    }
}
