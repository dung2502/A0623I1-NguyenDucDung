package com.example.blogs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/blog-home")
    public String showHomePage(){
        return "/index";
    }
}
