package com.sapient.springsession.mongodb.repository;

import com.sapient.springsession.mongodb.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderMongodbRepository extends MongoRepository<Order,String> {
}
