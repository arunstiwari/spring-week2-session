package com.sapient.springsession.mongodb.model;

import com.sapient.springsession.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends AuditModel {

    private long productId;
    private int quantity;
    private double price;

}
