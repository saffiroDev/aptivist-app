package com.example.aptivist.aptivistapp.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    T get(String id);


    T save(T t);

    T update(T t, String[] params);

    void delete(String id);
}
