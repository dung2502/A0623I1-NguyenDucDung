package com.example.teststudent.repository;

import java.util.List;

public interface IRepository<E> {
    List<E> selectAllObj();

    E selectObj(int id);

    boolean addObj(E e);

    boolean removeObj(int id);

    boolean updateObj(E e);
}
