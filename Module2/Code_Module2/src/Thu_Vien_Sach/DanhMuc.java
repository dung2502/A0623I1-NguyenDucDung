package Thu_Vien_Sach;
abstract class DanhMuc {
    protected String ma;
    protected String ten;
    protected String nhaXuatBan;
    protected int namXuatBan;
    protected int soTrang;
    protected double giaBan;
    protected int soLuong;

    public DanhMuc(String ma, String ten, String nhaXuatBan, int namXuatBan, int soTrang, double giaBan, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.soTrang = soTrang;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }
    // Phương thức trừu tượng tính thành tiền
    public abstract double tinhThanhTien();
}