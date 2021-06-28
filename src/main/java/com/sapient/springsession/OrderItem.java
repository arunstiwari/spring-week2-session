package com.sapient.springsession;

public class OrderItem {
    private String itemName;
    private Integer itemValue;
    private int quantity=0;

    public OrderItem(String itemName, Integer itemValue) {
        this.itemName = itemName;
        this.itemValue = itemValue;
    }

    public Integer getItemValue() {
        return itemValue;
    }

    public String getItemName() {
        return itemName;
    }

    public void incrementQuantity() {
        this.quantity +=1;
    }

    public int getQuantity() {
        return quantity;
    }
}
