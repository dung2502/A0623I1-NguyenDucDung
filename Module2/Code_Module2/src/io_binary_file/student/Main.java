package io_binary_file.student;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILE_PATH = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\io_binary_file\\student\\students.txt";
    public static void writeFile(List<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
            fos.close();
            System.out.println("Write done ! ");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Student> readFile(){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            ois.close();
            fis.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> students =new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeFile(students);
        List<Student> studentList = readFile();
        for (Student student : studentList){
            System.out.println(student);
        }
    }
}
