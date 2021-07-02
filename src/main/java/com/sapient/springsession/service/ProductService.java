package com.sapient.springsession.service;

import com.sapient.springsession.annotation.LogExecutionTime;
import com.sapient.springsession.exception.ProductNotFoundException;
import com.sapient.springsession.model.Product;
import com.sapient.springsession.repository.IProductRepository;
import com.sapient.springsession.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductRepository repository;


    public List<Product> fetchAllProducts() {
        return (List<Product>)repository.findAll();
    }
    @LogExecutionTime
    public void addProduct(Product product) {
        repository.save(product);
//        productRepository.saveProduct(product);
    }

    public Product fetchSpecificProductById(long id) {
        Optional<Product> productById = repository.findById(id);
        if (productById.isPresent())
            return productById.get();
        else
            throw new ProductNotFoundException("Product with id "+id+ " is not available");
    }

    public Product fetchSpecificProductByName(String name) {
        Optional<Product> productById = repository.findByName(name);
        if (productById.isPresent())
            return productById.get();
        else
            throw new ProductNotFoundException("Product with name "+name+ " is not available");
    }
}
