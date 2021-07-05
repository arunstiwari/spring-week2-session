package com.sapient.springsession.mongodb.service;

import com.sapient.springsession.mongodb.model.Order;
import com.sapient.springsession.mongodb.repository.IOrderMongodbRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderMongodbService {

    @Autowired
    private IOrderMongodbRepository repository;

    public Order updateOrderStatus(Order order)  {
        return repository.save(order);
    }

    public Order placeOrder(Order order) {
        log.info(" inside placeOrder : {}",order);
        Order savedOrder = repository.save(order);
        return savedOrder;
    }
}
