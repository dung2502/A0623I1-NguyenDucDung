package com.example.demo1.controller;


import com.example.demo1.model.Product;
import com.example.demo1.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductServices productServices;
    @GetMapping()
    public String showList(Model model){
        List<Product> productList = productServices.findAll();
        model.addAttribute("listProduct", productList);
        return "list";
    }

}
