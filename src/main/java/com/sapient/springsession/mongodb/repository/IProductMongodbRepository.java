package com.sapient.springsession.mongodb.repository;

import com.sapient.springsession.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductMongodbRepository extends MongoRepository<Product, String> {
}
