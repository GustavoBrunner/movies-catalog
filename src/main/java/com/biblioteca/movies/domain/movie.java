package com.biblioteca.movies.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class movie {

    @Id
    private String id;
}
