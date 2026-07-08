package com.crk.library.repository;

import java.util.*;

public class GenericRepository<T> implements Repository<T> {

    private final Map<Integer, T> data = new HashMap<>();

    @Override
    public void save(int id, T object) {
        data.put(id, object);
    }

    @Override
    public T findById(int id) {
        return data.get(id);
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>(data.values());
        Collections.sort(list, Comparator.comparing(Object::toString));
        return list;
    }

    @Override
    public void delete(int id) {
        data.remove(id);
    }

    public Set<Integer> getAllIds() {
        return new HashSet<>(data.keySet());
    }
}