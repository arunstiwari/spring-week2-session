package com.sapient.springsession.repository;

import com.sapient.springsession.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface ICartRepository extends CrudRepository<Cart, Long> {
}
