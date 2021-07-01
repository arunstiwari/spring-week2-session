package com.sapient.springsession.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem) {
        this.items.add(orderItem);
    }
}
