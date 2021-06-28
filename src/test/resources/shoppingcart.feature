Feature: A sample e-commerce shopping cart

  Scenario: Empty cart subtotal
    Given Customer has an empty cart
    Then Subtotal should be 0 dollars

  Scenario: Add a 10 dollar item to an empty cart
    Given Customer has an empty cart
    When I add a 10 dollar item named "Shirt"
    Then Subtotal should be 10 dollars

  Scenario: Add an item that already exists in the cart
    Given I have a cart with a 5 dollar item named 'Shirt'
    When I add a 5 dollar item named "Shirt"
    Then My quantity of products named "Shirt" should be 2