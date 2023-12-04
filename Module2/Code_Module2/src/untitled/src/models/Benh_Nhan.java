package models;

public abstract class Benh_Nhan {
    private int stt;
    private String ma_benh_an;
    private String ma_benh_nhan;
    private String ten;
    private String ngay_nhap_vien;
    private String ngay_ra_vien;
    private String ly_do;

    public Benh_Nhan() {
    }

    public Benh_Nhan(int stt, String ma_benh_an, String ten, String ngay_nhap_vien, String ngay_ra_vien, String ly_do) {
        this.stt = stt;
        this.ma_benh_an = ma_benh_an;
        this.ten = ten;
        this.ngay_nhap_vien = ngay_nhap_vien;
        this.ngay_ra_vien = ngay_ra_vien;
        this.ly_do = ly_do;
    }

    public Benh_Nhan(int stt, String ma_benh_an, String ma_benh_nhan, String ten, String ngay_nhap_vien, String ngay_ra_vien, String ly_do) {
        this.stt = stt;
        this.ma_benh_an = ma_benh_an;
        this.ma_benh_nhan = ma_benh_nhan;
        this.ten = ten;
        this.ngay_nhap_vien = ngay_nhap_vien;
        this.ngay_ra_vien = ngay_ra_vien;
        this.ly_do = ly_do;
    }

    public String getMa_benh_nhan() {
        return ma_benh_nhan;
    }

    public void setMa_benh_nhan(String ma_benh_nhan) {
        this.ma_benh_nhan = ma_benh_nhan;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMa_benh_an() {
        return ma_benh_an;
    }

    public void setMa_benh_an(String ma_benh_an) {
        this.ma_benh_an = ma_benh_an;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgay_nhap_vien() {
        return ngay_nhap_vien;
    }

    public void setNgay_nhap_vien(String ngay_nhap_vien) {
        this.ngay_nhap_vien = ngay_nhap_vien;
    }

    public String getNgay_ra_vien() {
        return ngay_ra_vien;
    }

    public void setNgay_ra_vien(String ngay_ra_vien) {
        this.ngay_ra_vien = ngay_ra_vien;
    }

    public String getLy_do() {
        return ly_do;
    }

    public void setLy_do(String ly_do) {
        this.ly_do = ly_do;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",stt,ma_benh_an,ma_benh_nhan,ten,ngay_nhap_vien,ngay_ra_vien,ly_do);
    }
}
