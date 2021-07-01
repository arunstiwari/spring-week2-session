package com.sapient.springsession.service;

import com.sapient.springsession.exception.OrderNotFoundException;
import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.OrderItem;
import com.sapient.springsession.model.OrderStatus;
import com.sapient.springsession.repository.IOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private IOrderRepository repository;

    public String confirmOrder(Order order) {
        return UUID.randomUUID().toString();
    }

    @Transactional
    public Order persisteOrder(Order order, OrderStatus validated) {
        order.getShipmentInfo().setOrder(order);
        order.getItems().stream().forEach(orderItem -> {
            orderItem.setOrder(order);
        });
        order.setStatus(validated);
        Order createdOrder = repository.save(order);
        return createdOrder;
    }

    @Transactional
    public void updateOrderStatus(Order order) {
        repository.save(order);
    }

    public List<Order> fetchAllOrders() {
        return (List<Order>) repository.findAll();
    }

    public Order findOrderById(long id) {
        Optional<Order> orderById = repository.findById(id);
        if (orderById.isPresent()){
            return orderById.get();
        }
        throw new OrderNotFoundException("No Order is Available for Id "+id);
    }

    @Transactional
    public void deleteOrder(long id) {
       repository.deleteById(id);
    }

    @Transactional
    public Order updateOrder(long id, List<OrderItem> orderItems) {
         log.info(" orderItems : {}",orderItems);
        Optional<Order> orderById = repository.findById(id);
        if (orderById.isPresent()){
            Order order = orderById.get();
            orderItems.stream().forEach(orderItem -> {
                orderItem.setOrder(order);
            });
            order.setItems(orderItems);
            Order save = repository.save(order);
            return save;
        }else {
            throw new OrderNotFoundException("Order by id "+id+ " is not found");
        }

    }
}
