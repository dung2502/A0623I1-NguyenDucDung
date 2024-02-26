package com.codegym.a0623i1.controllers;

import com.codegym.a0623i1.models.Student;
import com.codegym.a0623i1.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    //    DI
//    Có 3 cách: Field, constructor, setter
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String showList(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("listStudent", studentList);
        return "list";
    }

    @GetMapping("/create")
    public String showPageCreate() {
        return "create";
    }

    @PostMapping("/create")
    public void addStudent() {

    }
}
