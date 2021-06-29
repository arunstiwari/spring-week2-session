package com.sapient.springsession.controller;

import com.sapient.springsession.model.Product;
import com.sapient.springsession.service.ProductService;
import com.sapient.springsession.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductValidator productValidator;

    @InitBinder
    public void bind(WebDataBinder binder){
        binder.setValidator(productValidator);
    }


    @GetMapping("/products")
    public String showListOfProducts(Model model){
        List<Product> products =productService.fetchAllProducts();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/add-product")
    public String addProductFormPage(Model model){
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add-product")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
        log.info("Product to be added : {}",product);
        if (result.hasErrors()){
            return "add-product";
        }
        productService.addProduct(product);
        return "redirect:products";
    }
}
