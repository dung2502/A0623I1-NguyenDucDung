package com.example.thi.repository.repositoryImpl;

import com.example.thi.model.phongTro;
import com.example.thi.repository.BaseDAO;
import com.example.thi.repository.IPhong_tro_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Phong_Tro_DAO implements IPhong_tro_DAO {
    private static final String Select_All_Phong_Tro = "SELECT * FROM danhsachphongtro;";
    private static final String Delete_Phong = "delete from danhsachphongtro where stt = ?";

    @Override
    public List<phongTro> selectAllObj() {
        List<phongTro> phong_Tro = new ArrayList<>();
        phongTro phongTro1;
        try {
            PreparedStatement preparedStatement = BaseDAO.getConnectionJavaToDB().prepareStatement(Select_All_Phong_Tro);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                phongTro1 = new phongTro();
                phongTro1.setStt(result.getInt("stt"));
                phongTro1.setMa_phong_tro(result.getString("maphongtro"));
                phongTro1.setTen_nguoi_thue(result.getString("tennguoithue"));
                phongTro1.setSo_dien_thoai(result.getString("sodienthoai"));
                phongTro1.setNgay_thue(result.getDate("ngaybatdauthue"));
                phongTro1.setMa_thanh_toan(result.getInt("mathanhtoan"));
                phongTro1.setGhi_chu(result.getString("ghichu"));
                phong_Tro.add(phongTro1);
            }
            return phong_Tro;
        }catch (Exception e){
            System.out.println("Lỗi kết nối database! selectAll");
            e.printStackTrace();
        }
        return phong_Tro;
    }

    @Override
    public boolean removeObj(int id) {

        try {
            PreparedStatement preparedStatement = BaseDAO.getConnectionJavaToDB().prepareStatement(Delete_Phong);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println("Lỗi database removeObj!!!");
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<IPhong_tro_DAO> selectAllObjDAO() {
        return null;
    }

    @Override
    public phongTro selectObj(int id) {

        return null;
    }

    @Override
    public boolean addObj(phongTro phongTro) {
        return false;
    }
}
