package view;

import controller.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner(System.in);
    private static final Controller controller = new Controller();
    public static void displayMainMenu(){
        int select;
        do{
            try {
                System.out.println("----Chương trình quản lý bệnh án----");
                System.out.println("1. Thêm mới");
                System.out.println("2. Xóa");
                System.out.println("3. Xem danh sách các bệnh án");
                System.out.println("4. Thoát");
                System.out.println(" Hãy chọn chức năng: ");
                select = sc.nextInt();
                controller.Function(select);
            }
            catch (InputMismatchException e){
                System.out.println("Làm ơn nhập vào số!!");
            }
        } while (true);
    }
    public static void main(String[] args) {
        displayMainMenu();
    }
}
