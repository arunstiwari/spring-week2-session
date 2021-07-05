package com.sapient.springsession.controller.rest;

import com.sapient.springsession.model.Product;
import com.sapient.springsession.service.ProductService;
import com.sapient.springsession.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductRestController  {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductValidator productValidator;

    @InitBinder
    public void bind(WebDataBinder binder){
        binder.setValidator(productValidator);
    }

//    @ExceptionHandler(value = {ProductNotFoundException.class})
//    protected ResponseEntity<Object> handleException(ProductNotFoundException exception, WebRequest request){
//        log.error(" exception : {}",exception.getMessage());
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setInstance("");
//        errorResponse.setTitle("Searching the Product");
//        errorResponse.setType(String.valueOf(HttpStatus.NOT_FOUND.value()));
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }


    @GetMapping("/products ")
    public ResponseEntity<List<Product>> showListOfProducts(){
        List<Product> products = productService.fetchAllProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }



//    @GetMapping("/products/{id}")
//    public ResponseEntity<Object> fetchTheDetailOfSpecificProduct(@PathVariable("id") long id){
////       try {
//           Product product = productService.fetchSpecificProductById(id);
//           return new ResponseEntity(product, HttpStatus.OK);
////       }catch (ProductNotFoundException exception){
////           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with Id "+id+ "Not found", exception);
////       }
//    }

    @GetMapping("/products/{name}")
    public ResponseEntity<Object> fetchTheDetailOfSpecificProductByName(@PathVariable("name") String name){
//       try {
        Product product = productService.fetchSpecificProductByName(name);
        return new ResponseEntity(product, HttpStatus.OK);
//       }catch (ProductNotFoundException exception){
//           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with Id "+id+ "Not found", exception);
//       }
    }


    @PostMapping("/products")
    public ResponseEntity addProduct( @RequestBody Product product){
        log.info("Product to be added : {}",product);
        productService.addProduct(product);
        return new ResponseEntity("Product has been created successfully", HttpStatus.CREATED);

    }
}
