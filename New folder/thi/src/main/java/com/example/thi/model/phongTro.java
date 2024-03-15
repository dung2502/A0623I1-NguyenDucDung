package com.example.thi.model;

import java.sql.Date;

public class phongTro {
    private int stt;
    private String ma_phong_tro;
    private String ten_nguoi_thue;
    private String so_dien_thoai;
    private Date ngay_thue;
    private int ma_thanh_toan;
    private String ghi_chu;

    public phongTro() {
    }

    public phongTro(int stt, String ma_phong_tro, String ten_nguoi_thue, String so_dien_thoai, Date ngay_thue, int ma_thanh_toan, String ghi_chu) {
        this.stt = stt;
        this.ma_phong_tro = ma_phong_tro;
        this.ten_nguoi_thue = ten_nguoi_thue;
        this.so_dien_thoai = so_dien_thoai;
        this.ngay_thue = ngay_thue;
        this.ma_thanh_toan = ma_thanh_toan;
        this.ghi_chu = ghi_chu;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMa_phong_tro() {
        return ma_phong_tro;
    }

    public void setMa_phong_tro(String ma_phong_tro) {
        this.ma_phong_tro = ma_phong_tro;
    }

    public String getTen_nguoi_thue() {
        return ten_nguoi_thue;
    }

    public void setTen_nguoi_thue(String ten_nguoi_thue) {
        this.ten_nguoi_thue = ten_nguoi_thue;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public Date getNgay_thue() {
        return ngay_thue;
    }

    public void setNgay_thue(Date ngay_thue) {
        this.ngay_thue = ngay_thue;
    }

    public int getMa_thanh_toan() {
        return ma_thanh_toan;
    }

    public void setMa_thanh_toan(int ma_thanh_toan) {
        this.ma_thanh_toan = ma_thanh_toan;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
}
