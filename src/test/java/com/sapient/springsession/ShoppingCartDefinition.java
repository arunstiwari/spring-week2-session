package com.sapient.springsession;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ShoppingCartDefinition {

    private Cart cart = null;

    @Given("Customer has an empty cart")
    public void customer_has_an_empty_cart() {
        this.cart = new Cart();
    }

    @Then("Subtotal should be {int} dollars")
    public void subtotatal_should_be_dollars(Integer totalValueOfCart) {
        Assertions.assertTrue(this.cart.subtotal() == totalValueOfCart);
    }

    @When("I add a {int} dollar item named {string}")
    public void i_add_a_dollar_item_named(Integer itemValue, String itemName) {
        OrderItem orderItem = new OrderItem(itemName, itemValue);

        cart.addItem(orderItem);
    }

    @Given("I have a cart with a {int} dollar item named {string}")
    public void i_have_a_cart_with_a_dollar_item_named(Integer itemValue, String itemName) {
        OrderItem orderItem = new OrderItem(itemName, itemValue);
        this.cart = new Cart();
        this.cart.addItem(orderItem);
    }

    @Then("My quantity of products named {string} should be {int}")
    public void my_quantity_of_products_named_should_be(String itemName, Integer noOfQuantity) {
        int quantity = this.cart.getTotalQuantity(itemName);
        Assertions.assertEquals(noOfQuantity, quantity);
    }

}
