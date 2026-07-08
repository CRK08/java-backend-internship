package com.crk.library.repository;

import java.util.List;

public interface Repository<T> {

    void save(int id, T object);

    T findById(int id);

    List<T> findAll();

    void delete(int id);
}