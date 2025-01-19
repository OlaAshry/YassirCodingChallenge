@APIScenarios
Feature: Location Weather API Tests
  Verify the current weather API for valid and invalid cases

  @ValidRequest
  Scenario: Retrieve current weather for a valid city
    Given I have a valid API key
    When I request weather for "London"
    Then I should get a 200 status code
    And the response should contain "London" in the location name

  @InvalidCity
  Scenario: Retrieve weather for an invalid city
    Given I have a valid API key
    When I request weather for "InvalidCity123"
    Then I should see the response with error code 615 and error type "request_failed"

  @InvalidApiKey
  Scenario: Retrieve weather with an invalid API key
    Given I have an invalid API key
    When I request weather for "London"
    Then I should see the response with error code 101 and error type "invalid_access_key"

  @withoutApiKey
  Scenario: Fetch weather without an API key
    Given I have a weather API without an API key
    When I request weather for "London"
    Then I should see the response with error code 101 and error type "missing_access_key"

  @withoutSendingCity
  Scenario: Fetch weather without a city parameter
    Given I have a valid API key
    When I fetch weather information without a city
    Then I should see the response with error code 601 and error type "missing_query"

  @withoutApiKeyWithoutSendingCity
  Scenario: Fetch weather without both API key and city
    Given I have a weather API without an API key
    When I fetch weather information without a sending API key and also without a city
    Then I should see the response with error code 101 and error type "missing_access_key"


