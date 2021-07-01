package com.sapient.springsession.repository;

import com.sapient.springsession.exception.ProductNotFoundException;
import com.sapient.springsession.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void populateInitialData(){
        this.products.add(new Product(123, "product-1", 10.0));
        this.products.add(new Product(124, "product-2", 5.0));
        this.products.add(new Product(125, "product-3", 10.5));
        this.products.add(new Product(126, "product-4", 20.0));
    }

    public List<Product> fetchAllProducts() {
        return this.products;
    }

    public void saveProduct(Product product) {

        product.setId(UUID.randomUUID().getLeastSignificantBits());

        this.products.add(product);
    }

    public Product findProductByProductId(String id) {
        Optional<Product> first = products.stream().filter(product -> product.getId()== Integer.valueOf(id)).findFirst();
        if (first.isPresent())
            return first.get();
        throw new ProductNotFoundException("Product with id "+id+" is not found");
    }
}
