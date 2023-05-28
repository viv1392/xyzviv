@tag
Feature: purchase the order from Ecommerce website
    
    Background:
    Given I landed on Ecommerce Page

  @smoke
  Scenario Outline: submmit of the purchase order
    Given I logged in with <name> and <password>
    When  I add  product to Cart
    Then  I checkhout for the product 
    
   

    Examples: 
      |  name            | password           |
      | standard_user    | secret_sauce       |   
      
