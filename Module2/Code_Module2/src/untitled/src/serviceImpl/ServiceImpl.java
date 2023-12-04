package serviceImpl;

import models.Benh_Nhan;
import models.Benh_Nhan_Thuong;
import models.Benh_Nhan_Vip;
import service.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ServiceImpl implements Service {
    Scanner sc = new Scanner(System.in);
    private static final List<Benh_Nhan_Thuong> danh_sach_benh_nhan;
    static {
        danh_sach_benh_nhan = readFromFile();
    }
    private static final String PATH = "E:\\Code_Gym\\untitled\\src\\data\\medical_records.csv";
    @Override
    public void them_moi_benh_thuong(Benh_Nhan_Thuong benh_nhan) {
        if (tim_kiem_benh_nhan(benh_nhan.getMa_benh_an()) == null){
            danh_sach_benh_nhan.add(benh_nhan);
            WriteToFile(benh_nhan);
            System.out.println("thêm thành công");
        }
        else {
            System.out.println(" Không thêm được! ");
        }
    }


    @Override
    public void them_benh_nhan_vip(Benh_Nhan_Vip benh_nhan) {

    }

    @Override
    public void xoa_benh_an(Benh_Nhan_Thuong benh_nhan) {
        updateFile(benh_nhan, "remove");
        danh_sach_benh_nhan.remove(benh_nhan);
    }

    @Override
    public void hien_thi_benh_an() {
        if (!danh_sach_benh_nhan.isEmpty()) {
            for (Benh_Nhan_Thuong benhNhanThuong : danh_sach_benh_nhan) {
                System.out.println(benhNhanThuong);
            }
        }
    }

    @Override
   public Benh_Nhan_Thuong tim_kiem_benh_nhan(String ma) {
        for (Benh_Nhan_Thuong benh_nhan : danh_sach_benh_nhan) {
            if (benh_nhan.getMa_benh_an().equals(ma)) {
                return benh_nhan;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return danh_sach_benh_nhan.size();
    }

    public static List<Benh_Nhan_Thuong> readFromFile() {
        List<Benh_Nhan_Thuong> benh_nhan = new ArrayList<>();
        try {
            File file = new File(PATH);
            if (!file.exists()) {
                throw new FileNotFoundException("không thấy file! ");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");
                int stt = Integer.parseInt(array[0]);
                String ma_benh_an = array[1];
                String ma_benh_nhan = array[2];
                String ten = array[3];
                String ngay_nhap_vien = array[4];
                String ngay_ra_vien = array[5];
                String ly_do = array[6];
                Benh_Nhan_Thuong benhNhanThuong = new Benh_Nhan_Thuong(stt,ma_benh_an,ma_benh_nhan,ten,ngay_nhap_vien,ngay_ra_vien,ly_do);
                benh_nhan.add(benhNhanThuong);
            }
            System.out.println("hoàn thành");
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return benh_nhan;
    }
    public void WriteToFile(Benh_Nhan_Thuong benhNhan) {
        try {
            File file = new File(PATH);
            if (!file.exists()) {
                throw new FileNotFoundException(" Không tìm thấy file! ");
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(benhNhan.toString());
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }
    private void updateFile(Benh_Nhan_Thuong benhNhan, String update){
        try {
            File InFile = new File(PATH);
            File TFile = new File("tfile.csv");
            if(!InFile.exists()){
                System.out.println("Không tìm thấy file! ");
            }
            if (!TFile.exists()){
                System.out.println("File tạm đã thoát! ");
            }
            BufferedReader reader = new BufferedReader(new FileReader(InFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TFile));

            String Line;

            while ((Line = reader.readLine()) != null) {
                String[] arr = Line.split(",");
                String ma_benh_an = arr[0];
                if (Objects.equals(ma_benh_an, benhNhan.getMa_benh_an())) {
                    if (Objects.equals(update, "remove")){
                        System.out.println("Xóa đối tượng khỏi file!");
                    }
                } else {
                    writer.write(Line + "\n");
                }
            }
            writer.close();
            reader.close();
            if (!InFile.delete()) {
                System.out.println("lỗi xóa file");
                return;
            }
            if (!TFile.renameTo(InFile)) {
                System.out.println("Lỗi đổi tên file");
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        service.hien_thi_benh_an();
    }
}
