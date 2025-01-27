package com.biblioteca.movies.util;

import java.util.List;

import com.biblioteca.movies.util.contracts.DtoMapper;
import com.biblioteca.movies.util.contracts.ListDtoMapper;

public class Mapper {
    
    public static <T, T1> T map(T1 entity, DtoMapper<T,T1> mapper){
        return mapper.map(entity);
    }

    public static <T, T1> List<T> map(List<T1> entities, ListDtoMapper<T,T1> mapper){
        return mapper.map(entities);
    }

}
