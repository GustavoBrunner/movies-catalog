package com.biblioteca.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.dtos.UserViewDTO;
import com.biblioteca.movies.repositories.UserRespository;
import com.biblioteca.movies.services.contracts.UserService;
import com.biblioteca.movies.util.UserToUserDto;
import com.biblioteca.movies.util.contracts.DtoMapper;

@Service
public class UserServiceImpl implements UserService {

    private final UserRespository respository;

    private final UserToUserDto mapper; 
    
    @Autowired
    public UserServiceImpl(UserRespository respository) {
        this.respository = respository;
        mapper = new UserToUserDto();
    }

    @Override
    public UserViewDTO findById(Long id) {
        try{
            User entity = respository.findById(id).get(); 
            return mapper.mapToViewDto(entity);

        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserViewDTO> findAll() {
        List<User> users = respository.findAll();
        
        return mapper.mapToListDto(users);
    }

    @Override
    public UserViewDTO create(UserDTO entity) {
        User newEntity = mapper.mapToEntity(entity);
        //todo: add the token and the time expiration
        respository.saveAndFlush(newEntity);
        return mapper.mapToViewDto(newEntity);
    }

    @Override
    public UserViewDTO update(UserDTO entity) {
        User newEntity = mapper.mapToEntity(entity);
        respository.saveAndFlush(newEntity);
        return mapper.mapToViewDto(newEntity);
    }

    @Override
    public UserViewDTO delete(Long id) {
        User dev = respository.findById(id).get();
        respository.delete(dev);
        return mapper.mapToViewDto(dev);
    }


}
