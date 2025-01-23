package com.biblioteca.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblioteca.movies.domain.BaseUser;
import com.biblioteca.movies.domain.Developer;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
		BaseUser user = new Developer();
		
	}

}
