package com.biblioteca.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.dtos.UserViewDTO;
import com.biblioteca.movies.repositories.UserRespository;
import com.biblioteca.movies.services.contracts.UserService;
import com.biblioteca.movies.util.UserToUserDto;
import com.biblioteca.movies.util.contracts.DtoMapper;

public class UserServiceImpl implements UserService {

    private final UserRespository respository;
    
    @Autowired
    public UserServiceImpl(UserRespository respository) {
        this.respository = respository;
    }

    @Override
    public UserViewDTO findById(Long id) {
        User entity = respository.findById(id).get(); 
        return mapViewDto(entity, new UserToUserDto());
    }

    @Override
    public List<User> findAll() {
        return respository.findAll();
    }

    @Override
    public UserViewDTO create(UserDTO entity) {
        User newEntity = mapEntity(entity, new UserToUserDto());
        respository.saveAndFlush(newEntity);
        return mapViewDto(newEntity, new UserToUserDto());
    }

    @Override
    public UserViewDTO update(UserDTO entity) {
        User newEntity = mapEntity(entity, new UserToUserDto());
        respository.saveAndFlush(newEntity);
        return mapViewDto(newEntity, new UserToUserDto());
    }

    @Override
    public UserViewDTO delete(Long id) {
        User dev = respository.findById(id).get();
        respository.delete(dev);
        return mapViewDto(dev, new UserToUserDto());
    }


    @Override
    public UserDTO mapDto(User entity, DtoMapper<User, UserDTO, UserViewDTO> mapper) {
        return mapper.mapToDto(entity);
    }

    @Override
    public User mapEntity(UserDTO dto, DtoMapper<User, UserDTO, UserViewDTO> mapper) {
        return mapper.mapToEntity(dto);
    }

    @Override
    public UserViewDTO mapViewDto(User entity, DtoMapper<User, UserDTO, UserViewDTO> mapper) {
        return mapper.mapToViewDto(entity);
    }
}
