package com.biblioteca.movies.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException{

    public UserNotFoundException(String message){
        super(message);
    }
    public UserNotFoundException(){
        super("Entidade não encontrada nos registros");
    }

}
