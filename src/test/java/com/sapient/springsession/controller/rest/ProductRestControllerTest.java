package com.sapient.springsession.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.springsession.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeType;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void showListOfProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(4)))
                .andExpect(jsonPath("$.[0].name", is("product-1")))
        ;

        ;
    }

    @Test
    void fetchTheDetailOfSpecificProduct() throws Exception {
        mockMvc.perform(get("/products/product-2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("product-2")))
        ;

        ;
    }

    @Test
    void addProduct() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Product product1 =new Product("product-234","product-234", 40);

        String product = mapper.writeValueAsString(product1);

        mockMvc.perform(
                post("/products")
                .content(product)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
//                .andExpect(jsonPath("$.name", is("product-2")))
        ;

        ;
    }
}