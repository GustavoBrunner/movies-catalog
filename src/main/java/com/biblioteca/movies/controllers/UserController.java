package com.biblioteca.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.dtos.UserViewDTO;
import com.biblioteca.movies.services.contracts.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserViewDTO>> getAll() {
        List<UserViewDTO> developers = service.findAll();
        if(developers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(developers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserViewDTO> getById(@PathVariable Long id) {
        if(id.equals(null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserViewDTO entity = service.findById(id);
        

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity<UserViewDTO> create(@RequestBody UserDTO entity) {
        if(entity.equals(null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserViewDTO result = service.create(entity);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserViewDTO> update(@PathVariable Long id, @RequestBody UserDTO entity) {
        if(id.equals(null) || entity.equals(null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserViewDTO entityDb = service.create(entity);

        return new ResponseEntity<>(entityDb, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserViewDTO> delete(@PathVariable Long id){
        if(id.equals(null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserViewDTO result = service.delete(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
