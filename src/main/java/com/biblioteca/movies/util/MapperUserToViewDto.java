package com.biblioteca.movies.util;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserViewDTO;
import com.biblioteca.movies.util.contracts.DtoMapper;

public class MapperUserToViewDto implements DtoMapper<UserViewDTO, User> {

    @Override
    public UserViewDTO map(User entity) {
        return new UserViewDTO(entity.getUserName(), 
            entity.getEmail(), entity.getMovieQtd(), 
            entity.getUserType());
    }

}
