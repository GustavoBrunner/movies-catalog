package com.biblioteca.movies.util;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.dtos.UserViewDTO;
import com.biblioteca.movies.util.contracts.DtoMapper;

public class UserToUserDto implements DtoMapper<User, UserDTO, UserViewDTO> {

    @Override
    public UserDTO mapToDto(User entity) {
        return new UserDTO(entity.getId(), entity.getEmail(), entity.getUserName(), 
                           entity.getPassword(), entity.getUserType(), entity.getMovieQtd());
    }

    @Override
    public User mapToEntity(UserDTO dto) {
        return new User(dto);
    }

    @Override
    public UserViewDTO mapToViewDto(User entity) {
        return new UserViewDTO(entity.getUserName(), entity.getEmail(), entity.getMovieQtd(), entity.getUserType());
    }

    @Override
    public List<UserViewDTO> mapToListDto(List<User> listEntity) {
        List<UserViewDTO> userMapped = new ArrayList<>();
        for (User user : listEntity) {
            userMapped.add(mapToViewDto(user));
        }
        return userMapped;
    }
}