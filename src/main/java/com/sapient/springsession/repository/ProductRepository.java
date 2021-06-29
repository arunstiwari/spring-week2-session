package com.sapient.springsession.repository;

import com.sapient.springsession.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void populateInitialData(){
        this.products.add(new Product("product-1", "product-1", 10.0));
        this.products.add(new Product("product-2", "product-2", 5.0));
        this.products.add(new Product("product-3", "product-3", 10.5));
        this.products.add(new Product("product-4", "product-4", 20.0));
    }

    public List<Product> fetchAllProducts() {
        return this.products;
    }

    public void saveProduct(Product product) {
        product.setId(product.getName());
        this.products.add(product);
    }
}
