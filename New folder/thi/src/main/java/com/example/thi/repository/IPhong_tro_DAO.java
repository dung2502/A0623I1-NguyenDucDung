package com.example.thi.repository;

import com.example.thi.model.phongTro;

import java.util.List;

public interface IPhong_tro_DAO {
    List<phongTro> selectAllObj();

    List<IPhong_tro_DAO> selectAllObjDAO();
    phongTro selectObj(int id);
    boolean addObj(phongTro phongTro);
    boolean removeObj(int id);

}
