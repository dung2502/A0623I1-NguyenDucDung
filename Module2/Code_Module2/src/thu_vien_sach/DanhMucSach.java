package thu_vien_sach;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Lớp quản lý danh mục sách
class DanhMucSach {
    private final List<DanhMuc> danhSachSach = new ArrayList<>();

    // Đọc dữ liệu từ file text
    public void docDuLieuTuFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 9) {
                    String loaiSach = parts[0].trim();
                    String ma = parts[1].trim();
                    String ten = parts[2].trim();
                    int namXuatBan = Integer.parseInt(parts[3].trim());
                    String nhaXuatBan = parts[4].trim();
                    int soTrang = Integer.parseInt(parts[5].trim());
                    double giaBan = Double.parseDouble(parts[6].trim());
                    int soLuong = Integer.parseInt(parts[7].trim());
                    String thuocTinhThem = parts[8].trim();

                    if (loaiSach.equals("G")) {
                        // Nếu là sách giáo khoa
                        SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa(ma, ten, nhaXuatBan, namXuatBan, soTrang, giaBan, soLuong, thuocTinhThem);
                        themDanhMuc(sachGiaoKhoa);
                    } else if (loaiSach.equals("T")) {
                        // Nếu là tiểu thuyết
                        TieuThuyet tieuThuyet = new TieuThuyet(ma, ten, nhaXuatBan, namXuatBan, soTrang, giaBan, soLuong, thuocTinhThem);
                        themDanhMuc(tieuThuyet);
                   }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Thêm 1 danh mục sách (sách giáo khoa hoặc tiểu thuyết)
    public void themDanhMuc(DanhMuc danhMuc) {
        danhSachSach.add(danhMuc);
    }

    // Thống kê số lượng theo từng loại sách (sách giáo khoa, tiểu thuyết)
    public void thongKeSoLuongTheoLoaiSach() {
        int soLuongSachGiaoKhoa = 0;
        int soLuongTieuThuyet = 0;

        for (DanhMuc danhMuc : danhSachSach) {
            if (danhMuc instanceof SachGiaoKhoa) {
                soLuongSachGiaoKhoa += danhMuc.soLuong;
            } else if (danhMuc instanceof TieuThuyet) {
                soLuongTieuThuyet += danhMuc.soLuong;
            }
        }

        System.out.println("Số lượng sách giáo khoa: " + soLuongSachGiaoKhoa);
        System.out.println("Số lượng tiểu thuyết: " + soLuongTieuThuyet);
    }

    // Tìm sách có giá bán lớn nhất theo từng loại sách
    public void timSachGiaBanLonNhatTheoLoaiSach() {
        double maxGiaBanSachGiaoKhoa = 0;
        double maxGiaBanTieuThuyet = 0;

        for (DanhMuc danhMuc : danhSachSach) {
            if (danhMuc instanceof SachGiaoKhoa && danhMuc.giaBan > maxGiaBanSachGiaoKhoa) {
                maxGiaBanSachGiaoKhoa = danhMuc.giaBan;
            } else if (danhMuc instanceof TieuThuyet && danhMuc.giaBan > maxGiaBanTieuThuyet) {
                maxGiaBanTieuThuyet = danhMuc.giaBan;
            }
        }

        System.out.println("Sách giáo khoa có giá bán lớn nhất: " + maxGiaBanSachGiaoKhoa);
        System.out.println("Tiểu thuyết có giá bán lớn nhất: " + maxGiaBanTieuThuyet);
    }

    // Tìm sách có thành tiền lớn nhất
    public void timSachThanhTienLonNhat() {
        double maxThanhTien = 0;
        DanhMuc sachMaxThanhTien = null;

        for (DanhMuc danhMuc : danhSachSach) {
            double thanhTien = danhMuc.tinhThanhTien();
            if (thanhTien > maxThanhTien) {
                maxThanhTien = thanhTien;
                sachMaxThanhTien = danhMuc;
            }
        }

        System.out.println("Sách có thành tiền lớn nhất:");
        System.out.println(sachMaxThanhTien);
    }

    // Sắp xếp giảm dần theo thành tiền
    public void sapXepGiamDanTheoThanhTien() {
        Collections.sort(danhSachSach, new Comparator<DanhMuc>() {
            @Override
            public int compare(DanhMuc sach1, DanhMuc sach2) {
                double thanhTien1 = sach1.tinhThanhTien();
                double thanhTien2 = sach2.tinhThanhTien();

                if (thanhTien1 > thanhTien2) {
                    return -1;
                } else if (thanhTien1 < thanhTien2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println("Danh sách sách sau khi sắp xếp theo thành tiền giảm dần:");
        for (DanhMuc danhMuc : danhSachSach) {
            System.out.println(danhMuc);
        }
    }
}