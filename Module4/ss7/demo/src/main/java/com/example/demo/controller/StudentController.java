package com.example.demo.controller;

import com.example.demo.models.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    //    DI
//    Có 3 cách: Field, constructor, setter
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "nameSearch", defaultValue = "")String name) {
        List<Student> studentList = studentService.findAllByName(name);
        model.addAttribute("listStudent", studentList);
        return "list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("codeStudentDelete")Integer code) {
        studentService.deleteById(code);
        return "redirect:/students";
    }

    @GetMapping("/create")
    public String showPageCreate(Model model) {
        Student student = new Student();
        student.setCodeClass(3);
        model.addAttribute("student", student);
        model.addAttribute("classrooms", new int[] {1,2,3});
        return "create";
    }

    @PostMapping("/create")
    public String addStudent(@ModelAttribute("student") Student student, BindingResult bindingResult,
                             RedirectAttributes redirect) {
        if(bindingResult.hasErrors()) {
            return "create";
        }
        studentService.save(student);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
//       Redirect chuyển về trang list
        return "redirect:/students";
    }

    @GetMapping("/{code}/update")
    public String showPageUpdate(Model model, @PathVariable(name="code")Integer code) {

        return "update";
    }


}

