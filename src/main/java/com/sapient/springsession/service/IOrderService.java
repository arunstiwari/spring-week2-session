package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;

public interface IOrderService {
    Order getOrder(String orderId);

    Order placeOrder(Order order);
}
