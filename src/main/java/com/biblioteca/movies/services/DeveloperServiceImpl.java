package com.biblioteca.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.biblioteca.movies.domain.Developer;
import com.biblioteca.movies.dtos.DeveloperDTO;
import com.biblioteca.movies.dtos.DeveloperViewDTO;
import com.biblioteca.movies.repositories.DeveloperRespository;
import com.biblioteca.movies.services.contracts.DeveloperService;
import com.biblioteca.movies.util.DeveloperToDeveloperDto;
import com.biblioteca.movies.util.contracts.DtoMapper;

public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRespository respository;
    
    @Autowired
    public DeveloperServiceImpl(DeveloperRespository respository) {
        this.respository = respository;
    }

    @Override
    public DeveloperViewDTO findById(Long id) {
        Developer entity = respository.findById(id).get(); 
        return mapViewDto(entity, new DeveloperToDeveloperDto());
    }

    @Override
    public List<Developer> findAll() {
        return respository.findAll();
    }

    @Override
    public DeveloperViewDTO create(DeveloperDTO entity) {
        Developer newEntity = mapEntity(entity, new DeveloperToDeveloperDto());
        respository.saveAndFlush(newEntity);
        return mapViewDto(newEntity, new DeveloperToDeveloperDto());
    }

    @Override
    public DeveloperViewDTO update(DeveloperDTO entity) {
        Developer newEntity = mapEntity(entity, new DeveloperToDeveloperDto());
        respository.saveAndFlush(newEntity);
        return mapViewDto(newEntity, new DeveloperToDeveloperDto());
    }

    @Override
    public DeveloperViewDTO delete(Long id) {
        Developer dev = respository.findById(id).get();
        respository.delete(dev);
        return mapViewDto(dev, new DeveloperToDeveloperDto());
    }


    @Override
    public DeveloperDTO mapDto(Developer entity, DtoMapper<Developer, DeveloperDTO, DeveloperViewDTO> mapper) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Developer mapEntity(DeveloperDTO dto, DtoMapper<Developer, DeveloperDTO, DeveloperViewDTO> mapper) {
        return mapper.mapToEntity(dto);
    }

    @Override
    public DeveloperViewDTO mapViewDto(Developer entity, DtoMapper<Developer, DeveloperDTO, DeveloperViewDTO> mapper) {
        return mapper.mapToViewDto(entity);
    }
}
