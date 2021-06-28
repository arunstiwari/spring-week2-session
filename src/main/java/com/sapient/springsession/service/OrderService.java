package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.repository.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OrderService implements IOrderService {
    private OrderRepository orderRepository;

//    public OrderService(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }

    @PostConstruct
    public void init(){
        System.out.println("This method will be invoked once the object of this class is initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("This method will be invoked before the object is destroyed");
    }

    @Override
    public Order getOrder(String orderId) {
        System.out.println("orderRepository = " + orderRepository);
        return orderRepository.getOrderId(orderId);
    }


    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
