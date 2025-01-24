package com.biblioteca.movies.services.contracts;

import com.biblioteca.movies.domain.User;
import com.biblioteca.movies.dtos.UserDTO;
import com.biblioteca.movies.dtos.UserViewDTO;

public interface UserService extends GenericService<User, UserDTO, UserViewDTO> { }