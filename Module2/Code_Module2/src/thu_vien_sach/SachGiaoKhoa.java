package thu_vien_sach;

// Lớp con sách giáo khoa kế thừa từ lớp DanhMuc
class SachGiaoKhoa extends DanhMuc {
    private String khoiLop;

    public SachGiaoKhoa(String ma, String ten, String nhaXuatBan, int namXuatBan, int soTrang, double giaBan, int soLuong, String khoiLop) {
        super(ma, ten, nhaXuatBan, namXuatBan, soTrang, giaBan, soLuong);
        this.khoiLop = khoiLop;
    }

    @Override
    public double tinhThanhTien() {
        return giaBan * soLuong * 0.8; // Giảm 20%
    }

    @Override
    public String toString() {
        return "SachGiaoKhoa [ma=" + ma + ", ten=" + ten + ", nhaXuatBan=" + nhaXuatBan + ", namXuatBan=" + namXuatBan
                + ", soTrang=" + soTrang + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", khoiLop=" + khoiLop + "]";
    }
}
