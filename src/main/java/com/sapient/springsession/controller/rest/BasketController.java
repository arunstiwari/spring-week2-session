package com.sapient.springsession.controller.rest;

import com.sapient.springsession.model.Cart;
import com.sapient.springsession.model.CheckoutResponse;
import com.sapient.springsession.service.BasketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BasketController {

    @Autowired
    private BasketService basketService;

    @PostMapping("/checkout")
    public ResponseEntity checkoutCart(@RequestBody Cart cart){
        log.info(" cart {}",cart);
        CheckoutResponse response =  basketService.checkout(cart);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
