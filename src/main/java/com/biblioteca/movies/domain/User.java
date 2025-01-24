package com.biblioteca.movies.domain;

import java.time.LocalDateTime;

import com.biblioteca.movies.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
        this.userName =dto.userName();
        this.email = dto.email();
        this.password = dto.password();
        this.userType = dto.userType();
        this.movieQtd = dto.movieQtd();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "movie_qtd")
    private Integer movieQtd;

    @Column(name = "token")
    private String confirmationToken;

    @Column(name = "token_datetime")
    private LocalDateTime tokenExpirationTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

}
