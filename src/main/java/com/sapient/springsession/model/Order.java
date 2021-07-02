package com.sapient.springsession.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;

    private String orderId;
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;


    public void addOrderItem(OrderItem orderItem) {
        this.items.add(orderItem);
    }

}
