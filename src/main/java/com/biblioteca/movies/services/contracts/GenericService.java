package com.biblioteca.movies.services.contracts;

import java.util.List;
import java.util.Optional;



public interface GenericService<T, T1,T2> {
    public T2 findById(Long id);
    public List<T2> findAll();
    public T2 create(T1 entity);
    public T2 update(T1 entity);
    public T2 delete(Long id);


}
