package com.biblioteca.movies.util.contracts;

public interface DtoMapper<T, T1, T2> {
    T1 mapToDto(T entity);
    T mapToEntity(T1 dto);
    T2 mapToViewDto(T entity);
}
