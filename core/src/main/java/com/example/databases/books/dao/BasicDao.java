package com.example.databases.books.dao;

import java.util.List;

public interface BasicDao<T> {

    void save(T object);

    T get(int id);

    List<T> getAll();
}
