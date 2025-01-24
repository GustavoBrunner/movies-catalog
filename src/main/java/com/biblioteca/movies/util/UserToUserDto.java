package com.biblioteca.movies.util;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.dtos.UserViewDTO;
import com.biblioteca.movies.util.contracts.DtoMapper;

public class UserToUserDto implements DtoMapper<User, UserDTO, UserViewDTO> {

    @Override
    public UserDTO mapToDto(User entity) {
        return new UserDTO(entity.getId(), entity.getEmail(), entity.getName(), entity.getPassword());
    }

    @Override
    public User mapToEntity(UserDTO dto) {
        return new User(dto);
    }

    @Override
    public UserViewDTO mapToViewDto(User entity) {
        return new UserViewDTO(entity.getName(), entity.getEmail());
    }

}
