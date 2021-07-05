package com.sapient.springsession.mongodb.service;

import com.sapient.springsession.exception.CartNotFoundException;
import com.sapient.springsession.mongodb.model.Cart;
import com.sapient.springsession.mongodb.repository.ICartMongodbRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CartMongodbService {
    @Autowired
    private ICartMongodbRepository cartRepository;


    public Cart createCart(Cart cart) {

        Cart savedCart = cartRepository.save(cart);
        return savedCart;
    }


    public Cart fetchCartById(String cartId) {
        Optional<Cart> cartById = cartRepository.findById(cartId);
        if (cartById.isPresent())
            return cartById.get();
        throw  new CartNotFoundException("Cart with id "+ cartId + " is not found");
    }

    public Cart updateCart(String id, Cart cart) {
        Optional<Cart> cartById = cartRepository.findById(id);
        if (cartById.isPresent()) {
            Cart savedCart = cartById.get();
            savedCart.setCartItems(cart.getCartItems());
            Cart save = cartRepository.save(savedCart);
            return save;
        }
        throw  new CartNotFoundException("Cart with id "+ id + " is not found");
    }

    public boolean deleteCart(String cartId) {
        cartRepository.deleteById(cartId);
        return true;
    }
}
