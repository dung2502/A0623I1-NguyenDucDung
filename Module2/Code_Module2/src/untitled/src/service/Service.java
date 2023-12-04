package service;

import models.Benh_Nhan_Thuong;
import models.Benh_Nhan_Vip;

public interface Service {
    void them_moi_benh_thuong(Benh_Nhan_Thuong benh_nhan);
    void them_benh_nhan_vip(Benh_Nhan_Vip benh_nhan);
    void xoa_benh_an(Benh_Nhan_Thuong benh_nhan);
    void hien_thi_benh_an();
    Benh_Nhan_Thuong tim_kiem_benh_nhan(String ma);
    int getSize();


}
