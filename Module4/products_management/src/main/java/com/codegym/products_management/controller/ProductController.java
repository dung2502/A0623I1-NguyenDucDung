package com.codegym.products_management.controller;

import com.codegym.products_management.dto.ProductDTO;
import com.codegym.products_management.model.Category;
import com.codegym.products_management.model.Product;
import com.codegym.products_management.service.ICategoryService;
import com.codegym.products_management.service.IProductService;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private  IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public String showList(Model model, @RequestParam(name = "nameSearch", defaultValue = "") String nameProduct,
                           @RequestParam(name = "categoryName", defaultValue = "") String categoryName,
                           @RequestParam(name = "priceBefore", defaultValue = "0") Double priceBefore,
                           @RequestParam(name = "priceAfter", defaultValue = "1000000000") Double priceAfter,
                           @RequestParam(name = "page", defaultValue = "0") int page){
        if (page < 0) {
            page = 0;
        }
        Page<Product> products = productService.searchAllByPriceAndProductNameAndCategoryName(priceBefore, priceAfter, nameProduct, categoryName, PageRequest.of(page, 5));
//        Page<Product> products = productService.searchAllByProductNameAndCategoryName(nameProduct, categoryName, PageRequest.of(page, 5));
        if (products.isEmpty()){
            model.addAttribute("message", "No product found!");
        }
        model.addAttribute("nameSearch", nameProduct);
        model.addAttribute("categoryName", categoryName);
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
    public String createProduct(@Validated @ModelAttribute(name = "productDTO") ProductDTO productDTO, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model){
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "/product/create";
        }
        System.out.println(productDTO);
        String productName = productDTO.getProductName();
        Double price = productDTO.getPrice();
        boolean status = productDTO.isStatus();
        Category category = productDTO.getCategory();
        Product product = new Product(productName, price, status, category);
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create new Product successfully!");
        return "redirect:/products";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam(name = "productIdDelete") Integer productId, RedirectAttributes redirectAttributes){
        productService.remove(productId);
        redirectAttributes.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{productId}/edit")
    public String showEditPage(Model model, @PathVariable(name = "productId") Integer productId){
        Product product = productService.findById(productId);
        if (product == null){
            return "/error";
        }
        ProductDTO productDTO = new ProductDTO(product.getProductId(), product.getProductName(),
                product.getPrice(), product.isStatus(), product.getCategory());
        model.addAttribute("productDTO", productDTO);
        return "/product/edit";
    }
    @PostMapping("/update")
    public String updateProduct(@Validated @ModelAttribute(name = "productDTO") ProductDTO productDTO, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model){
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "/product/edit";
        }
        String productName = productDTO.getProductName();
        Double price = productDTO.getPrice();
        boolean status = productDTO.isStatus();
        Category category = productDTO.getCategory();
        Product product = new Product(productName, price, status, category);
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Update Product successfully!");
        return "redirect:/products";
    }
}
