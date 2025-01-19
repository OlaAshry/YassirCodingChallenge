@APIScenarios
Feature: Fixer API - Latest Rates
  @ValidRequest
  Scenario: Valid request with specific symbols
    Given I have a valid Fixer API key
    When I request latest rates for symbols "USD,CAD,JPY"
    Then I should get a 200 status code For Fixer endpoint
    Then the response should contain rates for "USD", "CAD", and "JPY"

  @InvalidApiKey
  Scenario: Validate request with Invalid API key
    Given I have an invalid Fixer API key
    When I request latest rates for symbols "USD,CAD,JPY"
    Then I should see the response for Fixer endpoint with error code 101 and error type "invalid_access_key"

  @withoutApiKey
  Scenario: Validate request with Missing API key
    Given I make a request without Fixer API key
    When I request latest rates for symbols "USD,CAD,JPY"
    Then I should see the response for Fixer endpoint with error code 101 and error type "missing_access_key"

   @invalidSymbols
  Scenario: Validate request with Invalid symbols
    Given I have a valid Fixer API key
    When I request latest rates for symbols "XYZ"
    Then I should see the response for Fixer endpoint with error code 202 and error type "invalid_currency_codes"

  @WithoutSymbols
  Scenario: Validate request with Missing symbols
    Given I have a valid Fixer API key
    When I request latest rates without symbols
    Then I should get a 200 status code For Fixer endpoint
    Then the response should contain rates for default currencies