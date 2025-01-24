package com.biblioteca.movies.dtos;

public record MovieDTO(
    Long id, String imdbId, String name,
    String title, String year, String released,
    String runtime, String genre, String director,
    String writer, String actors, String plot, 
    String language, String awards, String poster, 
    String imdbRating
    ) {   }
