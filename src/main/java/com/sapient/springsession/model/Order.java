package com.sapient.springsession.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    @SequenceGenerator(
            name = "seq_product",
            allocationSize = 1
    )
    private long id;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL )
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;

    //Order entity owns the shipment information and not vice versa, so mappedby attribute is w
    // with owner
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL , orphanRemoval = true,fetch = FetchType.LAZY)
    private ShipmentInfo shipmentInfo;

    public void addOrderItem(OrderItem orderItem) {
        this.items.add(orderItem);
    }
}
