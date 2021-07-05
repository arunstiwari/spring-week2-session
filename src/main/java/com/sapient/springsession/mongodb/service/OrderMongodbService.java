package com.sapient.springsession.mongodb.service;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.repository.IOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
public class OrderMongodbService {

    @Autowired
    private IOrderRepository repository;



    public String confirmOrder(Order order) {
        return UUID.randomUUID().toString();
    }

//    public Order persisteOrder(Order order, OrderStatus validated) {
//        order.setStatus(validated);
//        Order createdOrder = orderRepository.saveOrder(order);
//        return createdOrder;
//    }

    @Transactional
    public Order updateOrderStatus(Order order)  {
        return repository.save(order);
    }

    @Transactional
    public Order placeOrder(Order order) {
        log.info(" inside placeOrder : {}",order);
        Order savedOrder = repository.save(order);
        return savedOrder;
    }
}
