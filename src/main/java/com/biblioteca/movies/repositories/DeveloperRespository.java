package com.biblioteca.movies.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.movies.domain.Developer;

public interface DeveloperRespository extends JpaRepository <Developer, Long> {
    public Optional<Developer> findDeveloperByEmail(String email);
}
