package com.sapient.springsession.controller.rest;

import com.sapient.springsession.dto.OrderDto;
import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.OrderItem;
import com.sapient.springsession.model.OrderStatus;
import com.sapient.springsession.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public Order placeOrder(@RequestBody Order order){
        return orderService.persisteOrder(order, OrderStatus.INITIATED);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.fetchAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getSpecificOrder(@PathVariable("id") long id){
        return orderService.findOrderById(id);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id") long id){
         orderService.deleteOrder(id);
         return new ResponseEntity("Order with id "+ id+" is deleted", HttpStatus.OK);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@RequestBody OrderDto orderDto, @PathVariable("id") long id){
        return orderService.updateOrder(id, orderDto.getItems());
    }

}
