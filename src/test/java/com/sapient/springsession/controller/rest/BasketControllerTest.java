package com.sapient.springsession.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.springsession.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BasketControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void checkoutOrder() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Cart cart = new Cart();
//        Order order = new Order();
//        OrderItem orderItem = new OrderItem();
//        long productId = 123;
//        orderItem.setProductId(productId);
//        double itemPrice = 5.0;
//        orderItem.setPrice(itemPrice);
//        int itemQuantity = 2;
//        orderItem.setQuantity(itemQuantity);
//        order.addOrderItem(orderItem);

        CartItem cartItem = new CartItem();
        long productId = 123;
        cartItem.setProductId(productId);
        double itemPrice = 5.0;
        cartItem.setPrice(itemPrice);
        int itemQuantity = 2;
        cartItem.setQuantity(itemQuantity);

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        cart.setCartItems(cartItems);
        long customerId = 2323;
        cart.setCustomerId(customerId);
        String checkoutData = objectMapper.writeValueAsString(cart);
        System.out.println("checkoutData = " + checkoutData);

        mockMvc.perform(
                post("/checkout")
                .content(checkoutData)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status", is("CONFIRMED")))
                .andExpect(jsonPath("$.message", is("Order has been processed successfully")))
                .andExpect(jsonPath("$.orderNo", any(String.class)));
        ;
    }
}
/**
 * Happy Response Structure
 * {
 *    "status" : "",
 *    "message" : "",
 *    "orderNo" : ""
 * }
 *
 * Request Data Structure
 * {
 *     "order" : {
 *          "orderItems" : [
 *              {
 *                  "itemName" : "product-id",
 *                  "itemValue": : 24.0,
 *                  "itemQuantity": 2
 *              },
 *              {
 *                  "itemName" : "product-id",
 *  *                  "itemValue": : 24.0,
 *  *                  "itemQuantity": 2
 *              },
 *          ]
 *     },
 *     "customerId" : "customer-123",
 *     "creditCardInfo" : {
 *         "creditCardNo": "fdfd",
 *         "cvv": "zfdf"
 *     }
 * }
 */
