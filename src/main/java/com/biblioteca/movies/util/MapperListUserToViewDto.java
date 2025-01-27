package com.biblioteca.movies.util;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserViewDTO;
import com.biblioteca.movies.util.contracts.ListDtoMapper;

public class MapperListUserToViewDto implements ListDtoMapper<UserViewDTO, User> {

    @Override
    public List<UserViewDTO> map(List<User> entities) {
        List<UserViewDTO> userMapped = new ArrayList<>();
        for (User user : entities) {
            userMapped.add(Mapper.map(user, new MapperUserToViewDto()));
        }
        return userMapped;
    }
}
