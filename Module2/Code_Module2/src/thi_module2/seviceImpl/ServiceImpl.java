package thi_module2.seviceImpl;


import javacollectionframework.model.Product;
import thi_module2.model.Student;
import thi_module2.model.Teacher;
import thi_module2.service.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ServiceImpl implements Service {
    Scanner sc = new Scanner(System.in);
    private static final List<Student> studentList ;
    private static final List<Teacher> teacherList;
    private static final String PATH_STUDENT = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\thi_module2\\data\\Student.csv";
    private static final String PATH_TEACHER = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\thi_module2\\data\\Teacher.csv";



    static {
        studentList = readFromFileStudent();
        teacherList = readFromFileTeacher();
    }

    @Override
    public void addNewStudent(Student student) {
        if (searchStudent(student.getName()) == null){
            studentList.add(student);
            WriteToFile(student);
            System.out.println("Add completed");
        }
        else {
            System.out.println(" Add fail! ");
        }
    }

    @Override
    public void deleteStudent(Student student) {
        updateFile(student, "remove");
        studentList.remove(student);
    }

    @Override
    public void showStudent() {
        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }

    }

    @Override
    public void showTeacher() {
        if (!teacherList.isEmpty()) {
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        }

    }

    @Override
    public Student searchStudent(String name) {
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student search(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public static List<Student> readFromFileStudent() {
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(PATH_STUDENT);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");
                int id = Integer.parseInt(array[0]);
                String name = array[1];
                String dateOfBirth = array[2];
                String phoneNumber = array[3];
                String idClass = array[4];
                Student student = new Student(id, name, dateOfBirth,"", phoneNumber,idClass);
                students.add(student);
            }
            System.out.println("==================LOADING================");
            System.out.println("Successfully");
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
        return students;
    }

    public void WriteToFile(Student student) {
        try {
            File file = new File(PATH_STUDENT);
            if (!file.exists()) {
                throw new FileNotFoundException("File not fond! ");
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(student.toString());
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }
    private void updateFile(Student student, String update){
        try {
            File InFile = new File(PATH_STUDENT);
            File TFile = new File("tfile.csv");
            if(!InFile.exists()){
                System.out.println("File not found! ");
            }
            if (!TFile.exists()){
                System.out.println("Temp file exist! ");
            }
            BufferedReader reader = new BufferedReader(new FileReader(InFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TFile));

            String Line;

            while ((Line = reader.readLine()) != null) {
                String[] arr = Line.split(",");
                int id = Integer.parseInt(arr[0]);
                if (Objects.equals(id, student.getId())) {
                    if (Objects.equals(update, "remove")){
                        System.out.println("Deleted product name in file!");
                    }
                } else {
                    writer.write(Line + "\n");
                }
            }
            writer.close();
            reader.close();
            if (!InFile.delete()) {
                System.out.println("Error deleting original file");
                return;
            }
            if (!TFile.renameTo(InFile)) {
                System.out.println("Error renaming temporary file");
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    public static List<Teacher> readFromFileTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            File file = new File(PATH_TEACHER);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");
                int id = Integer.parseInt(array[0]);
                String name = array[1];
                String dateOfBirth = array[2];
                String phoneNumber = array[3];
                String idClass = array[4];
                Teacher teacher = new Teacher(id, name, dateOfBirth,"", phoneNumber,idClass);
                teachers.add(teacher);
            }
            System.out.println("==================LOADING================");
            System.out.println("Successfully");
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
        return teachers;
    }

}
