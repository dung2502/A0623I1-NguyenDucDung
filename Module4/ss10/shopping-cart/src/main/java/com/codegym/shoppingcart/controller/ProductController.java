package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Cart;
import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@SessionAttributes("cart")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model,@ModelAttribute Cart cart, @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "nameSearch", defaultValue = "") String name) {
        if (page < 0) {
            page = 0;
        }
        Page<Product> products = productService.searchAllByName(name, PageRequest.of(page, 12));
        if (products.isEmpty()){
            model.addAttribute("message", "No Products found!!!");
        }
        model.addAttribute("products",products);
        model.addAttribute("amountProduct", cart.countItemQuantity());
        model.addAttribute("nameSearch", name);
        model.addAttribute("page", page);
        return "/shop";
    }
    @GetMapping("/list")
    public String showList(Model model, @ModelAttribute Cart cart, @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "nameSearch", defaultValue = "") String name) {
        if (page < 0) {
            page = 0;
        }
        Page<Product> products = productService.searchAllByName(name, PageRequest.of(page, 12));
        if (products.isEmpty()){
            model.addAttribute("message", "No Products found!!!");
        }
        model.addAttribute("amountProduct", cart.countItemQuantity());
        model.addAttribute("products",products);
        model.addAttribute("nameSearch", name);
        model.addAttribute("page", page);
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute(name = "product") Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create new blog successfully!");
        return "redirect:/products/list";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product", product.get());
        return "/edit";
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute(name = "product") Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "update product successfully!");
        return "redirect:/products/list";
    }
    @GetMapping("/{id}/view")
    public String showView(@PathVariable(name = "id") Long id, Model model) {
        Product product = productService.findById(id).get();
        model.addAttribute("product", product);
        return "/view";
    }
    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id,RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete successfully!");
        return "redirect:/products/list";
    }

    @GetMapping("/{id}/add-to-cart")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart,
                            @RequestParam(name = "action", defaultValue = "") String action,
                            @RequestParam(name = "symbol",defaultValue = "") String symbol) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("set")) {
            cart.addProduct(productOptional.get(), symbol);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get(), symbol);
        return "redirect:/products/shop";
    }
}
