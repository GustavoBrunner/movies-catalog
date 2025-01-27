package com.biblioteca.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.domain.exceptions.UserNotFoundException;
import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.dtos.UserViewDTO;
import com.biblioteca.movies.repositories.UserRespository;
import com.biblioteca.movies.services.contracts.UserService;
import com.biblioteca.movies.util.Mapper;
import com.biblioteca.movies.util.MapperListUserToViewDto;
import com.biblioteca.movies.util.MapperUserDtoToEntity;
import com.biblioteca.movies.util.MapperUserToViewDto;

@Service
public class UserServiceImpl implements UserService {

    private final UserRespository respository;

    private final MapperUserDtoToEntity mapper; 
    
    @Autowired
    public UserServiceImpl(UserRespository respository) {
        this.respository = respository;
        mapper = new MapperUserDtoToEntity();
    }

    @Override
    public UserViewDTO findById(Long id) {
        User entity = respository.findById(id)
            .orElseThrow(() -> new UserNotFoundException()); 
        return Mapper.map(entity, new MapperUserToViewDto());
    }

    @Override
    public List<UserViewDTO> findAll() {
        List<User> users = respository.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException("Nenhum usuário encontrado nos registros!");
        }
        
        return Mapper.map(users, new MapperListUserToViewDto());
    }

    @Override
    public UserViewDTO create(UserDTO entity) {
        User newEntity = Mapper.map(entity, new MapperUserDtoToEntity());
        //todo: add the token and the time expiration
        respository.saveAndFlush(newEntity);
        return Mapper.map(newEntity, new MapperUserToViewDto());
    }

    @Override
    public UserViewDTO update(UserDTO entity) {
        User newEntity = respository.findById(entity.id())
        .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado para edição!")); 
        
        newEntity = Mapper.map(entity, new MapperUserDtoToEntity());
        respository.saveAndFlush(newEntity);
        return Mapper.map(newEntity, new MapperUserToViewDto());
    }

    @Override 
    public UserViewDTO delete(Long id) {
        User dev = respository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado para exclusão!"));
        respository.delete(dev);
        return Mapper.map(dev, new MapperUserToViewDto());
    }


}
