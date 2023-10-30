package thu_vien_sach;
public class Main {
    public static void main(String[] args) {
        DanhMucSach quanLySach = new DanhMucSach();
        quanLySach.docDuLieuTuFile("src\\Thu_Vien_Sach\\ThuVien.txt");

//         Thêm sách giáo khoa và tiểu thuyết để kiểm tra
        quanLySach.themDanhMuc(new SachGiaoKhoa("SK001", "Toán 10", "NXB Giáo Dục", 2022, 200, 120000, 50, "10A"));
        quanLySach.themDanhMuc(new TieuThuyet("TT001", "Harry Potter", "NXB Kim Đồng", 2005, 500, 150000, 30, "Fantasy"));

        quanLySach.thongKeSoLuongTheoLoaiSach();
        quanLySach.timSachGiaBanLonNhatTheoLoaiSach();
        quanLySach.timSachThanhTienLonNhat();
        quanLySach.sapXepGiamDanTheoThanhTien();
    }
}

