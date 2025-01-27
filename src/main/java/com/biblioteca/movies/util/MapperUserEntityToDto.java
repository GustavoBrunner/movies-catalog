package com.biblioteca.movies.util;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.util.contracts.DtoMapper;

public class MapperUserEntityToDto implements DtoMapper<UserDTO, User> {

    @Override
    public UserDTO map(User entity) {
        return new UserDTO(entity.getId(), entity.getEmail(), entity.getUserName(), 
                           entity.getPassword(), entity.getUserType(), entity.getMovieQtd());
    }

}
