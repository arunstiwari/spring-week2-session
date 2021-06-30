package com.sapient.springsession.service;

import com.sapient.springsession.annotation.LogExecutionTime;
import com.sapient.springsession.model.Product;
import com.sapient.springsession.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> fetchAllProducts() {

        List<Product> products = productRepository.fetchAllProducts();

        return products;
    }
    @LogExecutionTime
    public void addProduct(Product product) {
        productRepository.saveProduct(product);
    }
}
