package com.jpaToyProject.api.common.data;

import java.util.List;

public interface BaseRepository<T> {

    int create(T entity);

    List<T> read(T entity);

    int update(T entity);

    int delete(T entity);
}
