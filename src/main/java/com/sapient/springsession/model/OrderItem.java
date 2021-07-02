package com.sapient.springsession.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long productId;
    private int quantity;
    private double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable = false)
    private Order order;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("productId", productId)
                .append("quantity", quantity)
                .append("price", price)
                .toString();
    }
}
