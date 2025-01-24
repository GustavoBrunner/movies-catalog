package com.biblioteca.movies.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MovieViewDTO(
    @JsonProperty("imdbID") String imdbId, 
    @JsonProperty("Title") String title, 
    @JsonProperty("Year") String year, 
    @JsonProperty("Released") String released, 
    @JsonProperty("Rated") String rated, 
    @JsonProperty("imdbRating") String imdbRating,
    @JsonProperty("Runtime") String runtime, 
    @JsonProperty("Genre") String genre, 
    @JsonProperty("Director") String director,
    @JsonProperty("Writer") String writer, 
    @JsonProperty("Actors") String actors, 
    @JsonProperty("Plot") String plot, 
    @JsonProperty("Language") String language, 
    @JsonProperty("Awards") String awards, 
    @JsonProperty("Poster") String poster
) {

}
