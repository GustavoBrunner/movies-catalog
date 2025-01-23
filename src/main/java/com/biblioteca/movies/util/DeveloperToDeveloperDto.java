package com.biblioteca.movies.util;

import com.biblioteca.movies.domain.Developer;
import com.biblioteca.movies.dtos.DeveloperDTO;
import com.biblioteca.movies.dtos.DeveloperViewDTO;
import com.biblioteca.movies.util.contracts.DtoMapper;

public class DeveloperToDeveloperDto implements DtoMapper<Developer, DeveloperDTO, DeveloperViewDTO> {

    @Override
    public DeveloperDTO mapToDto(Developer entity) {
        return new DeveloperDTO(entity.getId(), entity.getEmail(), entity.getName(), entity.getPassword());
    }

    @Override
    public Developer mapToEntity(DeveloperDTO dto) {
        return new Developer(dto);
    }

    @Override
    public DeveloperViewDTO mapToViewDto(Developer entity) {
        return new DeveloperViewDTO(entity.getName(), entity.getEmail());
    }

}
