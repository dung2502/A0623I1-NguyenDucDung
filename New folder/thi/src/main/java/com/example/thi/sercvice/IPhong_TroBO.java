package com.example.thi.sercvice;

import com.example.thi.model.phongTro;
import com.example.thi.repository.IPhong_tro_DAO;

import java.util.List;

public interface IPhong_TroBO {
    List<phongTro> selectAllObj();
    phongTro selectObj(int id);
    boolean addObj(phongTro phongTro);
    boolean removeObj(int id);
    //DTO
    List<IPhong_tro_DAO> selectAllObjDAO();
}
