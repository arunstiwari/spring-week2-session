package com.sapient.springsession.mongodb.controller;

import com.sapient.springsession.mongodb.model.Cart;
import com.sapient.springsession.mongodb.service.CartMongodbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CartMongodbController {
    @Autowired
    private CartMongodbService cartService;

    @PostMapping("/mongodb/carts")
    public ResponseEntity createCart(@RequestBody Cart cart){
        log.info("create cart {}",cart);
        Cart createdCart =  cartService.createCart(cart);
        return new ResponseEntity(createdCart, HttpStatus.CREATED);
    }


    @PutMapping("/mongodb/carts/{id}")
    public ResponseEntity addItemsToCart( @RequestBody Cart cart,@PathVariable("id") long id){
        log.info("update cart:  {}, id : {} ",cart,id);
        Cart createdCart =  cartService.updateCart(String.valueOf(id),cart);
        return new ResponseEntity(createdCart, HttpStatus.CREATED);
    }
}
