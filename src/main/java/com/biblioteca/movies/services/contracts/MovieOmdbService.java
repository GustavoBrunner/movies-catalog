package com.biblioteca.movies.services.contracts;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.movies.dtos.MovieViewDTO;
import com.biblioteca.movies.infra.FeignClientConfig;

@FeignClient(value = "omdbapi", url = "${omdb.api.url}", configuration = FeignClientConfig.class)
public interface MovieOmdbService {
    @GetMapping("{title}")
    MovieViewDTO findMovieByName(@RequestParam("t") String title);

    @GetMapping("{imdbId}")
    MovieViewDTO findMovieByImdbId(@RequestParam("i") String imdbId);
}
