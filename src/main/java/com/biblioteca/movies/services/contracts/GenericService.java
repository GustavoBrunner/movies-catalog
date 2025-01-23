package com.biblioteca.movies.services.contracts;

import java.util.Optional;


public interface GenericService<T> {
    public Optional<T> findById(Long id);
    public Optional<T> create(T entity);
    public Optional<T> update(T entity);
    public Optional<T> delete(Long id);
}
