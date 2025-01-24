package com.biblioteca.movies.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.movies.domain.User;

public interface UserRespository extends JpaRepository <User, Long> {
    public Optional<User> findDeveloperByEmail(String email);
}
