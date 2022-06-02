Feature:  E-Commerce Shopping flow

  As a customer
  I want access to e-commerce platform
  so I can finalise my purchase

  //@UITest
  Scenario: Verify successful purchase by shopping flow
    Given I'm logged on customer portal "https://www.saucedemo.com/"
    And  I added an item to the shopping cart
    When I confirm the order
    Then The order has been dispatched
