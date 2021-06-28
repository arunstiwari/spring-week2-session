package com.sapient.springsession;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderItem> items = new ArrayList<>();
    public double subtotal() {
        double sum = items.stream().mapToDouble(OrderItem::getItemValue).sum();

        return sum;
    }

    public void addItem(OrderItem orderItem) {
        if (items.size() == 0){
            items.add(orderItem);
        }else {
            items.stream().forEach(item -> {
                if (item.getItemName().equals(orderItem.getItemName())){
                    item.incrementQuantity();
                }else {
                    items.add(orderItem);
                }
            });
        }
        items.add(orderItem);
    }

    public int getTotalQuantity(String itemName) {
        OrderItem orderItem = items.stream().filter(i -> i.getItemName().equals(itemName)).findFirst().get();
        return orderItem.getQuantity();
    }
}
