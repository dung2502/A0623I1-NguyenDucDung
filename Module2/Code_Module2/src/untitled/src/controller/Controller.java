package controller;

import models.Benh_Nhan_Thuong;
import service.Service;
import serviceImpl.ServiceImpl;
import until.Regex;
import until.Validate;

import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);
    private Service services = new ServiceImpl();

    public void Function(int choice) {
        switch (choice) {
            case 1:
                //them benh nhan
                addbenhnhan();
                break;
            case 2:
                //xoa benh nhan
                xoa_benh_nhan();
                break;
            case 3:
                //show danh sach
                services.hien_thi_benh_an();
                break;
            case 4:
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("Chose number 1 -> 4 :");
                break;
        }

    }

    public void addbenhnhan(){
        System.out.println("----Add new Student----");
        int stt = services.getSize() + 1;
        System.out.print("\nNhập mã bệnh án: ");
        String ma_benh_an = Validate.validate(Regex.ma_benh_an, sc.nextLine());
        System.out.print("\nNhập mã bệnh nhân ");
        String ma_benh_nhan = Validate.validate(Regex.ma_benh_nhan, sc.nextLine());
        System.out.print("\nNhập tên bệnh nhân: ");
        String ten = sc.nextLine();
        System.out.print("\nNhập ngày nhập viện: ");
        String ngay_nhap_vien = Validate.validate(Regex.ngay_ra_vien, sc.nextLine());
        System.out.print("\nNhập ngày ra viện: ");
        String ngay_ra_vien = Validate.validate(Regex.ngay_ra_vien, sc.nextLine());
        System.out.print("\nNhập lý do: ");
        String ly_do = sc.nextLine();
        Benh_Nhan_Thuong benh_nhan = new Benh_Nhan_Thuong(stt,ma_benh_an,ma_benh_nhan,ten,ngay_nhap_vien,ngay_ra_vien,ly_do);
        services.them_moi_benh_thuong(benh_nhan);
    }

    public void xoa_benh_nhan(){
        System.out.println("----Xóa bệnh nhân----");
        System.out.print("Mã bệnh án: ");
        String ma_benh_an = sc.nextLine();;
        if (services.tim_kiem_benh_nhan(ma_benh_an) != null){
            System.out.println("----Tìm thấy bệnh nhân----");
            System.out.println("Bạn có muốn xóa? Y : N");
            Benh_Nhan_Thuong benhNhanThuong = services.tim_kiem_benh_nhan(ma_benh_an);
            String select = sc.nextLine();
            if (select.equalsIgnoreCase("y")){
                System.out.println("Bạn chọn xóa");
                services.xoa_benh_an(benhNhanThuong);
                System.out.println("Bệnh nhân đã xóa!");
            } else {
                System.out.println("Bạn chọn không xóa!");
            }
        } else {
            System.out.println("Không tìm thấy bệnh nhân!");
        }
    }
}
