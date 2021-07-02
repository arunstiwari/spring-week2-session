package com.sapient.springsession.controller.rest;

import com.sapient.springsession.dto.CheckoutDTO;
import com.sapient.springsession.model.Cart;
import com.sapient.springsession.model.CheckoutResponse;
import com.sapient.springsession.service.BasketService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BasketController {

    @Autowired
    private BasketService basketService;

    @SneakyThrows
    @PostMapping("/checkout")
    public ResponseEntity checkoutCart(@RequestBody CheckoutDTO checkoutDTO){
        log.info(" checkoutDTO {}",checkoutDTO);
        CheckoutResponse response =  basketService.checkout(checkoutDTO.getCartId(), checkoutDTO.getCreditCardInfo());
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
