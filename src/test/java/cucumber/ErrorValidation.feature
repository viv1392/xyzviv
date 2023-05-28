@tag
Feature: Purchase order from Ecommerce

  Background: 
    Given I landed on the Ecommerce website

  @tag2
  Scenario Outline: login error msg
    Then I logg in with <name> and <password>

    Examples: 
      | name          | password       |
      | standard_user | secret_sauccve |
