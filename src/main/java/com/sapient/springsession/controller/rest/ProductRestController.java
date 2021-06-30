package com.sapient.springsession.controller.rest;

import com.sapient.springsession.model.Product;
import com.sapient.springsession.service.ProductService;
import com.sapient.springsession.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductValidator productValidator;

    @InitBinder
    public void bind(WebDataBinder binder){
        binder.setValidator(productValidator);
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> showListOfProducts(){
        List<Product> products =productService.fetchAllProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> fetchTheDetailOfSpecificProduct(@PathVariable("id") String id){
        Product product =productService.fetchSpecificProductById(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }


    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        log.info("Product to be added : {}",product);
        productService.addProduct(product);
        return new ResponseEntity("Product has been created successfully", HttpStatus.CREATED);

    }


}
