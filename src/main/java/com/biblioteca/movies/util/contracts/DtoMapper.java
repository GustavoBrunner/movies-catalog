package com.biblioteca.movies.util.contracts;

import java.util.List;

public interface DtoMapper<T, T1, T2> {
    T1 mapToDto(T entity);
    T mapToEntity(T1 dto);
    T2 mapToViewDto(T entity);
    List<T2> mapToListDto(List<T> listEntity);

}
