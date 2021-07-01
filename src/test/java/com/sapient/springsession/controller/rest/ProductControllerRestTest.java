package com.sapient.springsession.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.springsession.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class ProductControllerRestTest {

    @Test
    public void shouldReturnListOfProducts(){
        given()
                .log().all()
        .when()
            .get("http://localhost:9900/products")
        .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void shouldReturnSpecificProduct(){
        given()
                .log().all()
                .when()
                .get("http://localhost:9900/products/product-1")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void shouldAddProductSuccessfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Product product1 =new Product(334,"product-334", 40);

        String product = mapper.writeValueAsString(product1);

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(product)
                .when()
                .post("http://localhost:9900/products")
                .then()
                .statusCode(201)
                .log().all();
    }
}
