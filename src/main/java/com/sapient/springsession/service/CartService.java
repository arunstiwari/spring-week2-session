package com.sapient.springsession.service;

import com.sapient.springsession.exception.CartNotFoundException;
import com.sapient.springsession.model.Cart;
import com.sapient.springsession.repository.ICartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CartService {
    @Autowired
    private ICartRepository cartRepository;


    public Cart createCart(Cart cart) {
        cart.getCartItems().stream().forEach(cartItem -> {
            cartItem.setCart(cart);
        });
        Cart savedCart = cartRepository.save(cart);
        return savedCart;
    }


    public Cart fetchCartById(long cartId) {
        Optional<Cart> cartById = cartRepository.findById(cartId);
        if (cartById.isPresent())
            return cartById.get();
        throw  new CartNotFoundException("Cart with id "+ cartId + " is not found");
    }

    public Cart updateCart(long id, Cart cart) {
        Optional<Cart> cartById = cartRepository.findById(id);
        if (cartById.isPresent()) {

            Cart savedCart = cartById.get();
            cart.getCartItems().stream().forEach(cartItem -> cartItem.setCart(savedCart));
            savedCart.setCartItems(cart.getCartItems());
            Cart save = cartRepository.save(savedCart);
            return save;
        }
        throw  new CartNotFoundException("Cart with id "+ id + " is not found");
    }

    public boolean deleteCart(long cartId) {
        cartRepository.deleteById(cartId);
        return true;
    }
}
