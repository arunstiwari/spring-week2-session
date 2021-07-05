package com.sapient.springsession.mongodb.repository;

import com.sapient.springsession.mongodb.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICartMongodbRepository extends MongoRepository<Cart, String> {
}
