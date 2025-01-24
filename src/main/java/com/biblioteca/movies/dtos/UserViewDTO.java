package com.biblioteca.movies.dtos;

import com.biblioteca.movies.domain.UserType;

public record UserViewDTO(String userName, String email, Integer movieQtd, UserType userType) { }
