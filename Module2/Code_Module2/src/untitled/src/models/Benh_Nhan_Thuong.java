package models;

public class Benh_Nhan_Thuong extends Benh_Nhan {
    private int phi_nam_vien;

    public Benh_Nhan_Thuong() {
    }

    public Benh_Nhan_Thuong(int stt, String ma_benh_an, String name, String ngay_nhap_vien, String ngay_ra_vien, String ly_do) {
        super(stt, ma_benh_an, name, ngay_nhap_vien, ngay_ra_vien, ly_do);
        this.phi_nam_vien = phi_nam_vien;
    }

    public Benh_Nhan_Thuong(int stt, String maBenhAn, String maBenhNhan, String ten, String ngayNhapVien, String ngayRaVien, String lyDo) {
        super(stt, maBenhAn, maBenhNhan, ten, ngayNhapVien, ngayRaVien, lyDo);
        this.phi_nam_vien = phi_nam_vien;
    }

    public int getPhi_nam_vien() {
        return phi_nam_vien;
    }

    public void setPhi_nam_vien(int phi_nam_vien) {
        this.phi_nam_vien = phi_nam_vien;
    }

    @Override
    public String toString() {
      return super.toString();
    }
}
