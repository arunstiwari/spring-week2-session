package com.sapient.springsession.mongodb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sapient.springsession.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem  {

    private long productId;
    private int quantity;
    private double price;

}