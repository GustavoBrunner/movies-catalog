package com.biblioteca.movies.services.contracts;

import java.util.List;
import com.biblioteca.movies.util.contracts.DtoMapper;


public interface GenericService<T, T1,T2> {
    public T2 findById(Long id);
    public List<T2> findAll();
    public T2 create(T1 entity);
    public T2 update(T1 entity);
    public T2 delete(Long id);

    public T1 mapDto(T entity, DtoMapper<T,T1,T2> mapper);
    public T mapEntity(T1 dto, DtoMapper<T,T1,T2> mapper);
    public T2 mapViewDto(T entity, DtoMapper<T,T1,T2> mapper);
    public List<T2> mapToListDto(List<T> entities, DtoMapper<T,T1,T2> mapper);

}
