package com.biblioteca.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.movies.domain.Developer;
import com.biblioteca.movies.dtos.DeveloperDTO;
import com.biblioteca.movies.dtos.DeveloperViewDTO;
import com.biblioteca.movies.services.contracts.DeveloperService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/developer")
public class DeveloperController {

    private final DeveloperService service;

    @Autowired
    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Developer>> getAll() {
        List<Developer> developers = service.findAll();
        if(developers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(developers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperViewDTO> getById(@PathVariable Long id) {
        if(id.equals(null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        DeveloperViewDTO entity = service.findById(id);
        if(entity.equals(null)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity<DeveloperViewDTO> create(@RequestBody DeveloperDTO entity) {
        if(entity.equals(null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        DeveloperViewDTO result = service.create(entity);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DeveloperViewDTO> update(@PathVariable Long id, @RequestBody DeveloperDTO entity) {
        if(id.equals(null) || entity.equals(null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        DeveloperViewDTO entityDb = service.create(entity);

        return new ResponseEntity<>(entityDb, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DeveloperViewDTO> delete(@PathVariable Long id){
        if(id.equals(null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        DeveloperViewDTO result = service.delete(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
