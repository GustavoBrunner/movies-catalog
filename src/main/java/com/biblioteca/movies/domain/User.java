package com.biblioteca.movies.domain;

import com.biblioteca.movies.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    public User(UserDTO dto){
        this.id = dto.id();
        this.name =dto.name();
        this.email = dto.email();
        this.password = dto.password();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = true)
    protected String email;
    
    @Column(nullable = true)
    protected String password;
    
    @Column(nullable = true)
    protected String name;
}
