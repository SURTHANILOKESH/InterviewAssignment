@ALL
@UC02

Feature: Navigate to Saucedemo application

  Scenario Outline: Add the products to cart and checkout and verify products displayed on the checkout page.
    Given Navigate to saucedemo application
    Then Verify user lands on home page
    When User enter the <username> and <password>
    And Click on login button
    Then Verify user lands on the inventory page
		And Add the products <products> to the cart
		When user click on cart icon
		Then verify user should be able to view products <products> displayed
    Examples: 
      | username      | password     |products|
      | standard_user | secret_sauce |Sauce Labs Backpack,Sauce Labs Bike Light|
 
