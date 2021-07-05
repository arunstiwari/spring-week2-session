package com.sapient.springsession.mongodb.controller;

import com.sapient.springsession.dto.CheckoutDTO;
import com.sapient.springsession.model.CheckoutResponse;
import com.sapient.springsession.mongodb.service.BasketMongodbService;
import com.sapient.springsession.service.BasketService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BasketMongodbController {

    @Autowired
    private BasketMongodbService basketService;

    @SneakyThrows
    @PostMapping("/mongodb/checkout")
    public ResponseEntity checkoutCart(@RequestBody CheckoutDTO checkoutDTO){
        log.info(" checkoutDTO {}",checkoutDTO);
        CheckoutResponse response =  basketService.checkout(String.valueOf(checkoutDTO.getCartId()), checkoutDTO.getCreditCardInfo());
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}

