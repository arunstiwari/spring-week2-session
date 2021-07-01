package com.sapient.springsession.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    @SequenceGenerator(
            name = "seq_product",
            allocationSize = 1
    )
    private long id;

    private String name;
    private double price;

//    public Product(String id, String name, double price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//    }
}
