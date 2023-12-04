package models;

public class Benh_Nhan_Vip extends Benh_Nhan {
    private String vip;

    public Benh_Nhan_Vip() {
    }

    public Benh_Nhan_Vip(int stt, String ma_benh_an, String name, String ngay_nhap_vien, String ngay_ra_vien, String ly_do, String vip) {
        super(stt, ma_benh_an, name, ngay_nhap_vien, ngay_ra_vien, ly_do);
        this.vip = vip;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return  super.toString() + "," + vip;
    }
}
