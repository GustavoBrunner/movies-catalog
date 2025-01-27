package com.biblioteca.movies.util.contracts;

import java.util.List;

public interface ListDtoMapper <T, T1>{
    public List<T> map(List<T1> entities);

}
