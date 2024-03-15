package com.example.thi.sercvice.Sercvice;

import com.example.thi.model.phongTro;
import com.example.thi.repository.IPhong_tro_DAO;
import com.example.thi.repository.repositoryImpl.Phong_Tro_DAO;
import com.example.thi.sercvice.IPhong_TroBO;

import java.util.List;

public class Phong_TroBO implements IPhong_TroBO {
    private IPhong_tro_DAO phongTroDAO = new Phong_Tro_DAO();
    @Override
    public List<phongTro> selectAllObj() {
        return phongTroDAO.selectAllObj();
    }

    @Override
    public phongTro selectObj(int id) {
        return null;
    }

    @Override
    public boolean addObj(phongTro phongTro) {
        return false;
    }

    @Override
    public boolean removeObj(int id) {

        return phongTroDAO.removeObj(id);
    }

    @Override
    public List<IPhong_tro_DAO> selectAllObjDAO() {
        return null;
    }
}
