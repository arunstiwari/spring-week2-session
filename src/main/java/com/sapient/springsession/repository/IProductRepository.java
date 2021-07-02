package com.sapient.springsession.repository;

import com.sapient.springsession.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends CrudRepository<Product,Long> {
    Optional<Product> findByName(String name);

}
