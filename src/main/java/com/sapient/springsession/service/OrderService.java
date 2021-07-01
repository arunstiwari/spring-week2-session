package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.OrderStatus;
import com.sapient.springsession.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public String confirmOrder(Order order) {
        return UUID.randomUUID().toString();
    }

    public Order persisteOrder(Order order, OrderStatus validated) {
        order.setStatus(validated);
        Order createdOrder = orderRepository.saveOrder(order);
        return createdOrder;
    }

    public void updateOrderStatus(Order order) {
        orderRepository.updateOrderStatus(order);
    }
}
