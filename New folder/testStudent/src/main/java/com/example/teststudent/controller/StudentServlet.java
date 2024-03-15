package com.example.teststudent.controller;

import com.example.teststudent.DTO.StudentDTO;
import com.example.teststudent.model.Student;
import com.example.teststudent.service.IClassBO;
import com.example.teststudent.service.IStudentBO;
import com.example.teststudent.service.ServiceImpl.ClassesBO;
import com.example.teststudent.service.ServiceImpl.StudentBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/studentsManager")
public class StudentServlet extends HttpServlet{
        private static final long serialVersionUID = 1L;
        private IStudentBO studentBO;
        private IClassBO classBO;

        public void init() {
            classBO = new ClassesBO();
            studentBO = new StudentBO();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            String action = req.getParameter("action");
            if(action == null){
                action = "";
            }
            try {
                switch (action){
                    case "create":
                        ShowCreateStudent(req, resp);
                        break;
                    case "edit":
                        ShowUpdateStudent(req,resp);
                        break;
                    case "delete" :
                        deleteStudent(req,resp);
                        break;
                    default:
                        ListStudent(req,resp);
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private void ListStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
            List<StudentDTO> studentList = studentBO.selectAllStudentDTO();
            req.setAttribute("listStudent", studentList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("student/list.jsp");
            dispatcher.forward(req, resp);
        }
    private void ShowUpdateStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int id  = Integer.parseInt(req.getParameter("id"));
        Student exitsStudent = studentBO.selectObj(id);
        System.out.println(exitsStudent);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/edit.jsp");
        req.setAttribute("student", exitsStudent);
        req.setAttribute("classesList", classBO.selectAllObj());
        dispatcher.forward(req, resp);
    }
    private void ShowCreateStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/create.jsp");
        req.setAttribute("classesList", classBO.selectAllObj());
        dispatcher.forward(req, resp);
        }
    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentBO.removeObj(id);
        List<StudentDTO> listStudents = studentBO.selectAllStudentDTO();
        req.setAttribute("listStudent", listStudents);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(req, resp);
    }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           req.setCharacterEncoding("UTF-8");
           String action = req.getParameter("action");
           if (action == null){
               action ="";
           }
           try {
               switch (action){
                   case "edit":
                       updateStudent(req, resp);
                       break;
                   case "search" :

                       break;
                   case "create" :
                       createStudent(req, resp);
                       break;
                   default:
                       ListStudent(req,resp);
                       break;
               }
           } catch (Exception e) {
               throw new RuntimeException(e);
           }

        }
    private void updateStudent(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String checkDate = req.getParameter("date");
        Date dob;
        if (checkDate == null || checkDate.isEmpty()){
            dob = null;
        } else {
            dob = Date.valueOf(checkDate);
        }
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(id, name, dob, gender, phone, classId);
        studentBO.updateObj(student);
        RequestDispatcher dispatcher =req.getRequestDispatcher("student/edit.jsp");
        req.setAttribute("student", student);
        dispatcher.forward(req, resp);
    }
    private void createStudent(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        Date dob = Date.valueOf(req.getParameter("dob"));
        System.out.println(dob);
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(name, dob, gender, phone, classId);
        studentBO.addObj(student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/create.jsp");
        req.setAttribute("classesList", classBO.selectAllObj());
        dispatcher.forward(req,resp);
    }
    }