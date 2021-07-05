package com.sapient.springsession.mongodb.repository;

import com.sapient.springsession.mongodb.model.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
