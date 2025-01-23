package com.biblioteca.movies.services.contracts;

import java.util.List;
import java.util.Optional;


public interface GenericService<T> {
    public Optional<T> findById(Long id);
    public List<T> findAll();
    public T create(T entity);
    public T update(T entity);
    public T delete(Long id);
}
