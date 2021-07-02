package com.sapient.springsession.controller.rest;

import com.sapient.springsession.model.Cart;
import com.sapient.springsession.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/carts")
    public ResponseEntity createCart(@RequestBody Cart cart){
        log.info("create cart {}",cart);
        Cart createdCart =  cartService.createCart(cart);
        return new ResponseEntity(createdCart, HttpStatus.CREATED);
    }


    @PutMapping("/carts/{id}")
    public ResponseEntity addItemsToCart( @RequestBody Cart cart,@PathVariable("id") long id){
        log.info("update cart:  {}, id : {} ",cart,id);
        Cart createdCart =  cartService.updateCart(id,cart);
        return new ResponseEntity(createdCart, HttpStatus.CREATED);
    }
}
