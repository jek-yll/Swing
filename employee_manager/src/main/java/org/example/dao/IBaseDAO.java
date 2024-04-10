package org.example.dao;

import java.util.List;

public interface IBaseDAO <T>{
    int add(T obj);
    int delete(int id);
    int update(T obj);
    List<T> getAll();
    T getById(int id);
}
