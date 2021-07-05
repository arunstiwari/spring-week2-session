package com.sapient.springsession.mongodb.repository;

import com.sapient.springsession.mongodb.model.Cart;
import com.sapient.springsession.mongodb.model.CartItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ICartMongodbRepositoryTest {

    @Autowired
    ICartMongodbRepository cartMongodbRepository;

    @Test
    public void createCart(){
        Cart cart = new Cart();
        List<CartItem> cartItems = List.of(
                new CartItem(12,2, 20),
                new CartItem(13,   1 , 30)
        );
        cart.setCartItems(cartItems);
        cart.setCustomerId(123);
        cartMongodbRepository.save(cart);
    }

}