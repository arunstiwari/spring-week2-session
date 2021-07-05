package com.sapient.springsession.mongodb;

import com.sapient.springsession.mongodb.model.Address;
import com.sapient.springsession.mongodb.model.Product;
import com.sapient.springsession.mongodb.model.ProductCategory;
import com.sapient.springsession.mongodb.model.User;
import com.sapient.springsession.mongodb.repository.IProductCategoryRepository;
import com.sapient.springsession.mongodb.repository.IProductMongodbRepository;
import com.sapient.springsession.mongodb.repository.IUserMongodbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitMongodbDatabase {
    @Autowired
    private IProductMongodbRepository productMongodbRepository;

    @Autowired
    private IProductCategoryRepository productCategoryRepository;

    @Autowired
    IUserMongodbRepository repository;

    @PostConstruct
    public void initDatbase(){

        productCategoryRepository.deleteAll();
        productMongodbRepository.deleteAll();
        repository.deleteAll();

        User user = new User();
        user.setAge(25);
        user.setName("User-1");
        user.setAddresses(
                List.of(
                        new Address("city-1","110001"),
                        new Address("city-2","110002")

                ))
        ;
        repository.save(user);

        User user1 = new User();
        user1.setAge(35);
        user1.setName("User-2");
        user1.setAddresses(
                List.of(
                        new Address("city-3","110001"),
                        new Address("city-4","110002")

                ))
        ;
        repository.save(user1);

        List<ProductCategory> productCategories = List.of(
                new ProductCategory("Electronics"),
                new ProductCategory("Toys")
        );

//        productCategoryRepository.saveAll(productCategories);

//        List<ProductCategory> allCategories = productCategoryRepository.findAll();

        List<Product> products = List.of(
            new Product(null,"Description 1", "Wooden Toys", 10, productCategories.get(1)),
                new Product(null,"Laptop", "Apple Laptop", 1000, productCategories.get(0))
        );
        productMongodbRepository.saveAll(products);



    }
}
