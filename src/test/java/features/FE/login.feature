@FEScenarios
Feature: Login to SauceDemo

  Scenario Outline: Successful and unsuccessful login attempts
    Given I open Swag Labs website
    When I enter username "<username>" and password "<password>"
    And I click on the login button
    Then I should see the result "<result>"

    Examples:
      | username      | password      | result                      |
      | standard_user | secret_sauce  | Products page displayed     |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.   |
      | standard_user | wrong_pass    | Epic sadface: Username and password do not match any user in this service |