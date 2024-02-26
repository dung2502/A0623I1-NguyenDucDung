package com.example.test11.controller;


import com.example.test11.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/create")
public class UserController {

    @GetMapping
    public String showPageCreate(Model model){
        model.addAttribute("user", new User());
        return "create";
    }
    @PostMapping("/create-user")
    public String createUser(Model model, @ModelAttribute User user){
        model.addAttribute("user", user);
        return "index";
    }
}
