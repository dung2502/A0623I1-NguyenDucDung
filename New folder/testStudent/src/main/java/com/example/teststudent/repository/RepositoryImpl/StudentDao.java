package com.example.teststudent.repository.RepositoryImpl;

import com.example.teststudent.DTO.StudentDTO;
import com.example.teststudent.model.Student;
import com.example.teststudent.repository.BaseDao;
import com.example.teststudent.repository.IStudentDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentDao implements IStudentDao {
    private static final String Select_All_student = "select * from student;";
    private static final String Update_Student_SQL = "update student set studentName = ?, dob = ?, gender = ?, " +
            "phoneNumber = ?, classId = ? where studentId = ?";
    private static final String Select_Student_By_Id = "select studentName, dob, gender, phoneNumber, classId " +
            "from student where studentId = ?";
    private static final String Insert_Student = "insert into student (studentName, dob, gender, phoneNumber, " +
            "classId) values (?, ?, ?, ?, ?)";
    private static final String Delete_Student = "delete from student where studentId = ?";
    private static final String SELECT_ALL_STUDENT_DTO = "  select studentId, studentName, dob, gender, phoneNumber, " +
            "classname from student join classes on student.classId = classes.classId;";

    @Override
    public List<Student> selectAllObj() {
        List<Student> students = new ArrayList<>();
        Student student;
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Select_All_student);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                student = new Student();
                student.setId(result.getInt("studentId"));
                student.setName(result.getString("studentName"));
                student.setDate(result.getDate("dob"));
                int gender =result.getInt("gender");
                if (gender == 1){
                    student.setGender("nam");
                }else {
                    student.setGender("nữ");
                }
                student.setPhoneNumber(result.getString("phoneNumber"));
                student.setClassID(result.getInt("classId"));
                students.add(student);
            }
            return students;
        }catch (Exception e){
            System.out.println("Lỗi kết nối database!");
        }
        return students;
    }

    @Override
    public List<StudentDTO> selectAllObjDTO() {

        List<StudentDTO> studentDTOList = new ArrayList<>();
        StudentDTO studentDTO;
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(SELECT_ALL_STUDENT_DTO);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                studentDTO = new StudentDTO();
                studentDTO.setId(rs.getInt("studentId"));
                studentDTO.setName(rs.getString("studentName"));
                studentDTO.setDate(rs.getDate("dob"));
                int genderId = rs.getInt("gender");
                if (genderId == 1){
                    studentDTO.setGender("Nam");
                } else {
                    studentDTO.setGender("Nữ");
                }
                studentDTO.setPhoneNumber(rs.getString("phoneNumber"));
                studentDTO.setClassName(rs.getString("className"));
                studentDTOList.add(studentDTO);
            }
            return studentDTOList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentDTOList;
    }

    @Override
    public Student selectObj(int id) {
        try{
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Select_Student_By_Id);
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()){
                Student student = new Student();
                student.setName(result.getString("studentName"));
                student.setDate(result.getDate("dob"));
                int genderId = result.getInt("gender");
                if (genderId == 1){
                    student.setGender("Nam");
                } else {
                    student.setGender("Nữ");
                }
                student.setPhoneNumber(result.getString("phoneNumber"));
                student.setClassID(result.getInt("classId"));
                return student;

            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối database11!!");
        }
        return null;
    }

    @Override
    public boolean addObj(Student student) {
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Insert_Student);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setDate(2,student.getDate());
            int gender;
            if (Objects.equals(student.getGender(), "Nam")){
                gender = 1;
            }
            else{
                gender = 2;
            }
            preparedStatement.setInt(3,gender);
            preparedStatement.setString(4,student.getPhoneNumber());
            preparedStatement.setInt(5, student.getClassID());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối database addObj!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeObj(int id) {
        try {
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Delete_Student);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            System.out.println("Lỗi database removeObj!!!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateObj(Student student) {
        try{
            PreparedStatement preparedStatement = BaseDao.getConnectionJavaToDB().prepareStatement(Update_Student_SQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, student.getDate());
            int gender ;
            if (student.getGender().equals("Nam")){
                gender = 1;
            }else{
                gender = 2;
            }
            preparedStatement.setInt(3, gender);
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setInt(5, student.getClassID());
            preparedStatement.setInt(6, student.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối database creatObj!!");
        }
        return false;
    }
}
