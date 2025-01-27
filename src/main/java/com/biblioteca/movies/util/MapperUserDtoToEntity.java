package com.biblioteca.movies.util;


import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.util.contracts.DtoMapper;

public class MapperUserDtoToEntity implements DtoMapper<User, UserDTO> {

    @Override
    public User map(UserDTO entity) {
        return new User(entity);
    }
}