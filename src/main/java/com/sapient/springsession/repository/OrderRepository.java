package com.sapient.springsession.repository;

import com.sapient.springsession.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {
    List<Order> orders = new ArrayList<>();

    public Order saveOrder(Order order) {
//        order.setOrderId(UUID.randomUUID().toString());
        orders.add(order);
        return order;
    }

    public void updateOrderStatus(Order order) {
        orders.stream().forEach(order1 -> {
//            if (order1.getOrderId().equals(order.getOrderId()))
                order1.setStatus(order.getStatus());
        });
    }
}
