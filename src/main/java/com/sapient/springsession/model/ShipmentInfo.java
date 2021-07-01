package com.sapient.springsession.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "shipments")
public class ShipmentInfo  extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String shipmentAddress;

    @JsonIgnore
    @OneToOne
    private Order order;
}
