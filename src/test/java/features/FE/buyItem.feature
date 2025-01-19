@FEScenarios
Feature: Buy items from SauceDemo

  Scenario Outline: Successfully purchase items from SauceDemo
    Given I open Swag Labs website
    When I enter username "<username>" and password "<password>"
    And I click on the login button
    When I click Add to Cart
    And I click on the cart icon
    And Verify That Item has been added to the cart
    And I proceed to checkout
    And I enter my information
    And I complete the purchase
    Then I should see a confirmation message "Thank you for your order!"

    Examples:
      | username      | password      |
      | standard_user | secret_sauce  |
