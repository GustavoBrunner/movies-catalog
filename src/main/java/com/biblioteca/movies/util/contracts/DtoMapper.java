package com.biblioteca.movies.util.contracts;

import java.util.List;

public interface DtoMapper<T, T1> {
    T map(T1 entity);

}
