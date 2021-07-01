package com.sapient.springsession.repository;

import com.sapient.springsession.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IOrderRepository extends CrudRepository<Order, Long> {

}
