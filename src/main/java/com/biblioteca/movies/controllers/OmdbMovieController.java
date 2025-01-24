package com.biblioteca.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.movies.dtos.MovieViewDTO;
import com.biblioteca.movies.services.contracts.MovieOmdbService;


@RestController
@RequestMapping("/api/omdb-movies")
public class OmdbMovieController {

    private final MovieOmdbService omdbService;
    
    
    @Autowired
    public OmdbMovieController(MovieOmdbService omdbService) {
        this.omdbService = omdbService;
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<MovieViewDTO> getByTitle(@PathVariable String title){
        try{
            MovieViewDTO movie = omdbService.findMovieByName(title);
            if(movie == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(movie, HttpStatus.OK);

        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/imdb-id/{imdbId}")
    public ResponseEntity<MovieViewDTO> getByImdbId(@PathVariable String imdbId){
        try{
            MovieViewDTO movie = omdbService.findMovieByImdbId(imdbId);
            if(movie == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
