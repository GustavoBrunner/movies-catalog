package com.biblioteca.movies.domain;

import com.biblioteca.movies.dtos.DeveloperDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "developer")
@Table(name = "developer")
public class Developer extends BaseUser {
    public Developer(DeveloperDTO dto){
        this.id = dto.id();
        this.name =dto.name();
        this.email = dto.email();
        this.password = dto.password();
    }
}
