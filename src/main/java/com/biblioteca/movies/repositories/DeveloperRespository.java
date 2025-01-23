package com.biblioteca.movies.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.movies.domain.Developer;

public interface DeveloperRespository extends JpaRepository <Long, Developer> {

}
