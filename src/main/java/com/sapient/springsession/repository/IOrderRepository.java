package com.sapient.springsession.repository;

import com.sapient.springsession.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository extends CrudRepository<Order, Long> {
}
