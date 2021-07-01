package com.sapient.springsession.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;


}
