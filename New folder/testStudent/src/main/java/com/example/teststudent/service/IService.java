package com.example.teststudent.service;

import java.util.List;

public interface IService<E> {
    List<E> selectAllObj();
    E selectObj (int id);
    boolean addObj(E e);

    boolean removeObj(int id);

    boolean updateObj(E e);


}
