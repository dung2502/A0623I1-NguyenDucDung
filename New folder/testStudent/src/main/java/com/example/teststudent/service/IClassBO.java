package com.example.teststudent.service;

import com.example.teststudent.model.Classes;
import com.example.teststudent.service.IService;


import java.util.List;

public interface IClassBO extends IService<Classes> {
    @Override
    List<Classes> selectAllObj();
}
