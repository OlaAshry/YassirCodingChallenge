@FEScenarios
Feature: After Login, I want to open an item detail's page

  Scenario Outline: Verify that I view the item details
    Given I open Swag Labs website
    When I enter username "<username>" and password "<password>"
    And I click on the login button
    And I click on an item
    Then I can view the details successfully

    Examples:
      |username|password|
      |standard_user   |secret_sauce|