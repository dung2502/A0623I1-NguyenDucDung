package com.example.products_project.controller;


import com.example.products_project.dto.ProductDTO;
import com.example.products_project.model.Category;
import com.example.products_project.model.Product;
import com.example.products_project.service.ICategoryService;
import com.example.products_project.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public String show(Model model, @RequestParam(name = "nameSearch", defaultValue = "") String nameProduct,
                       @RequestParam(name = "categoryName", defaultValue = "") String categoryName,
                       @RequestParam(name = "priceBefore", defaultValue = "0")double priceBefore,
                       @RequestParam(name = "priceAfter", defaultValue = "10000000000000") double priceAfter,
                       @RequestParam(name = "page", defaultValue = "0") int page){
    if (page < 0){
        page = 0;
    }
        Page<Product> products = productService.searchAllProductByPriceAndProductName(priceBefore, priceAfter, nameProduct,categoryName, PageRequest.of(page, 5));
    if (products.isEmpty()){
        model.addAttribute("message", "No product can found!!!!!!!!");
    }
    model.addAttribute("nameSearch", nameProduct);
    model.addAttribute(("categoryName"), categoryName);
    model.addAttribute("priceBefore", priceBefore);
    model.addAttribute("priceAfter", priceAfter);
    model.addAttribute("page", page);
    model.addAttribute("products", products);
     return "/product/list";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productDTO", productDTO);
        return "/product/create";
    }
    @PostMapping("/save")
    public  String createProduct(@Validated @ModelAttribute(name = "productDTO") ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.findAll());
            return "/product/create";
        }
        System.out.println(productDTO);
        String productName = productDTO.getProductName();
        double price = productDTO.getPrice();
        boolean status = productDTO.isStatus();
        Category category = productDTO.getCategory();
        Product product = new Product(productName, price, status, category);
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create a new products");
        return "redirect:/product";

    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam(name = "productIdDelete") Integer productId, RedirectAttributes redirectAttributes){
        productService.delete(productId);
        redirectAttributes.addFlashAttribute("message", "Complete delete product!!");
        return "redirect:/product";
    }
    @GetMapping("/{productId}/edit")
    public String showEditPage(Model model, @PathVariable(name = "productId") Integer productId){
        Product product = productService.findById(productId);
        if (product == null){
            return "/product/list";
        }
        ProductDTO productDTO = new ProductDTO(product.getProductId(), product.getProductName(), product.getPrice(), product.isStatus(),product.getCategory());
        model.addAttribute("productDTO", productDTO);
        System.out.println(product);
        return "/product/edit";
    }
    @PostMapping("/update")
    public String updateProduct(@Validated @ModelAttribute(name = "productDTO") ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.findAll());
            return "/product/edit";
        }
        Integer productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        double productPrice = productDTO.getPrice();
        boolean status = productDTO.isStatus();
        Category category = productDTO.getCategory();
        Product product = new Product(productId, productName, productPrice,status,category);
        productService.save(product);
        System.out.println(product);
        redirectAttributes.addFlashAttribute("message", "Update product complete !");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String showPage(Model model, @PathVariable(name = "id") Integer productId){
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "/product/view";
    }
}
