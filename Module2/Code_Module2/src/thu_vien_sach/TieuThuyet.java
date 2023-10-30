package thu_vien_sach;

// Lớp con tiểu thuyết kế thừa từ lớp DanhMuc
class TieuThuyet extends DanhMuc {
    private String theLoai;

    public TieuThuyet(String ma, String ten, String nhaXuatBan, int namXuatBan, int soTrang, double giaBan, int soLuong, String theLoai) {
        super(ma, ten, nhaXuatBan, namXuatBan, soTrang, giaBan, soLuong);
        this.theLoai = theLoai;
    }

    @Override
    public double tinhThanhTien() {
        return giaBan * soLuong * 0.6; // Giảm 40%
    }

    @Override
    public String toString() {
        return "TieuThuyet [ma=" + ma + ", ten=" + ten + ", nhaXuatBan=" + nhaXuatBan + ", namXuatBan=" + namXuatBan
                + ", soTrang=" + soTrang + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", theLoai=" + theLoai + "]";
    }
}
