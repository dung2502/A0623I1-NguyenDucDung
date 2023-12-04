package StudentManagement.repositoryIpml;

import StudentManagement.models.Student;
import StudentManagement.models.StudyClass;
import StudentManagement.models.Teacher;
import StudentManagement.repository.Repository;
import StudentManagement.until.NotFoundStudentException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositoryImpl implements Repository {
    static Scanner sc = new Scanner(System.in);
    private static final List<Student> studentList;
    private static final String STUDENT_SRC = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\StudentManagement\\data\\students.csv";
    private static final String TEACHER_SRC = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\StudentManagement\\data\\teachers.csv";
    private static final String CLASS_SRC = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\StudentManagement\\data\\class.csv";
    static {
        studentList = readFromFile();
    }
    private static List<Student> readFromFile(){
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(STUDENT_SRC);
            if (!file.exists()){
                throw new FileNotFoundException("Student's file does not found!");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null){
//                System.out.println(line);
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                String born = arr[2];
                String gender = arr[3];
                String phoneNumber = arr[4];
                int classId = Integer.parseInt(arr[5]);
                Student student = new Student(id,name,born,gender,phoneNumber,classId);
                students.add(student);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
        return students;
    }
    private void writeToFile(Student student){
        try {
            File file = new File(STUDENT_SRC);
            if (!file.exists()){
                throw new FileNotFoundException("Student's file does not found!");
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(student.toString());
            bw.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
    }
    private void updateInFile(){
        try {
            File File = new File(STUDENT_SRC);
            if (!File.exists()){
                throw new FileNotFoundException("Student's file not found!");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(File));
            for (Student stu: studentList){
                writer.write(stu.toString());
                writer.newLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewStudent(Student student) {
        studentList.add(student);
        System.out.println("Add new successfully!");
        writeToFile(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentList.remove(student);
        int newId = 0;
        for (Student stu: studentList){
            stu.setId(++newId);
        }
        updateInFile();
    }

    @Override
    public void displayStudentList() {
        List<StudyClass> studyClasses = readClassFile();
        for (Student stu : studentList) {
            for (StudyClass study : studyClasses) {
                int classId = study.getId();
                if (stu.getClassId() == classId) {
                    String name = study.getName();
                    System.out.println(stu.showInfo() + "\nClassname: " + name);
                    System.out.println();
                }
            }
        }
    }
    private List<Teacher> readTeacherFile(){
        List<Teacher> teachers = new ArrayList<>();
        try {
            File file = new File(TEACHER_SRC);
            if (!file.exists()){
                throw new FileNotFoundException("Teacher's file does not found!");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = " ";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                String born = arr[2];
                String gender = arr[3];
                String phoneNumber = arr[4];
                Teacher teacher = new Teacher(id,name,born,gender,phoneNumber);
                teachers.add(teacher);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
        return teachers;
    }
    private List<StudyClass> readClassFile(){
        List<StudyClass> studyClasses = new ArrayList<>();
        try {
            File file = new File(CLASS_SRC);
            if (!file.exists()){
                throw new FileNotFoundException("Class file does not found!");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = " ";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int teacherId = Integer.parseInt(arr[2]);
                StudyClass studyClass = new StudyClass(id, name, teacherId);
                studyClasses.add(studyClass);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
        return studyClasses;
    }
    @Override
    public void showTeacherInfo(int teacherId) {
        List<Teacher> teacherList = readTeacherFile();
        for (Teacher t: teacherList){
            if (t.getId() == teacherId){
                System.out.println(t.showInfo());
            }
        }
    }

    @Override
    public Student searchStudent(String name) {
        return NotFoundStudentException.checkStudentContain(studentList, name);
    }

    @Override
    public Student searchStudent(int id) {
        for (Student str: studentList){
            if (str.getId() == id){
                return str;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return studentList.size();
    }

    @Override
    public boolean isEmpty() {
        return studentList.isEmpty();
    }

    public static void main(String[] args) {
        Repository service = new RepositoryImpl();
        service.displayStudentList();
    }
}
