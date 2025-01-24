package com.biblioteca.movies.dtos;


import com.biblioteca.movies.domain.UserType;

public record UserDTO(Long id, String email, String userName, String password, 
                      UserType userType, Integer movieQtd) { }
