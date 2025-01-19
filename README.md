# Yassir Automation Coding Challenge

This project is a hybrid automation framework designed for API and UI testing using Cucumber, Rest-Assured, and Selenium.

## Project Structure
### Main Folder (src/main/java)
- **Pages**
    - `CartPage`: Handles the cart-related UI operations.
    - `CheckOutPage`: Manages the checkout process.
    - `HomePage`: Contains methods for home page interactions.
    - `InformationPage`: Handles user information inputs.
    - `ItemDetailsPage`: Focuses on item details actions.
    - `LoginPage`: Manages login-related operations.
- **Utils**
    - `Config`: Manages configurations and environment setup.
    - `TestBase`: Contains the base setup for tests, including driver initialization and teardown.
---
### Test Folder (src/test/java)
#### **API Tests**
- **Features**
    - `fixer.feature`: Defines scenarios for the Fixer API.
    - `locationWeatherApi.feature`: Scenarios for testing the weather location API.

- **Step Definitions**
    - `FixerStepDef`: Implements Fixer API test steps.
    - `LocationWeatherApiStepDef`: Implements weather API test steps.

#### **Frontend (FE) Tests**
- **Features**
    - `buyItem.feature`: Scenarios for buying items.
    - `itemDetails.feature`: Scenarios for viewing item details.
    - `login.feature`: Scenarios for login functionality.
  
- **Step Definitions**
    - `BuyItems_StepDef`: Implements steps for buying items.
    - `ItemDetails_StepDef`: Implements steps for item details.
    - `Login_StepDef`: Implements steps for login.
  
#### **Runners**
- `TestRunner`: Configured to run tests based on tags defined in the feature files.
---
## Technologies Used
- **Java**: Core programming language.
- **Cucumber**: BDD framework for defining feature files and step definitions.
- **Rest-Assured**: For API automation.
- **Selenium**: For UI testing.
- **Maven**: For dependency management and build.
- **IntelliJ IDEA**: IDE for development.

---
## Set Up Configuration:
- Add necessary API keys and URLs in the Config class

## How to Run the Tests

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
- To run specific tag tests, modify the TestRunner by using 
  - **FE Tag: @FEScenarios** To run all the FE Scenarios 
  - **API Tag: @APIScenarios** To run all the API Scenarios

## Features
# API Testing:
Validates responses for Fixer API and Weather API, including scenarios for valid and invalid inputs.
# UI Testing:
Cover end end-to-end scenarios such as login, buying items, and checking item details.

-------------------------------------------------------------------
## Part 1
## Proposed Testcases
# Weather Endpoint
1. Retrieve current weather for a valid city
2. Retrieve weather for an invalid city
3. Retrieve weather with an invalid API key
4. Fetch weather without an API key
5. Fetch weather without a city parameter
6. Fetch weather without both API key and city
---------------------------------------------------
# Fixer Endpoint:
1- Validate request with specific symbols
2- Validate request with Invalid API key
3- Validate request with Missing API key
4- Validate request with Invalid symbols
5- Validate request with Missing symbols
-------------------------------------------------------------------------
## Part 2
# Used the "https://www.saucedemo.com/" Site
1. Implement the login with valid and invalid cases 
2. Implement buy item flow 
3. Implement the item details page
--------------------------------------------------------------------------
## Part 3
# 1.If I were to utilize an existing API test automation framework for both web and mobile test automation, here are the actions I would initiate:
1. Determine how reusable the existing API framework components are for web and mobile automation.
2. Ensure test logic is decoupled from the platform-specific details.
3. Identify common functionalities, such as authentication or test data management, that can be shared across web, mobile, and API tests.
4. Integrate with UI Automation Tools: For Web Automation Use Selenium for automating web UI testing and For Mobile Automation Use Appium for mobile UI testing.
5. Create a common test base that includes shared utilities, configurations, and reusable methods for API, web, and mobile automation.
6. Use Rest-Assured (for API tests) alongside mobile/web automation tools.
7. Use a single BDD tool like Cucumber so that the feature files can work across all platforms.
8. Implement tagging in feature files to separate API, web, and mobile test cases while allowing cross-platform testing if needed.
9. Implement a shared data layer to enable API responses to feed into web and mobile UI test cases:
   Example: Fetch data (e.g., user credentials) via API and use it in login tests for both web and mobile platforms.
10. Use frameworks like Allure or ExtentReports to consolidate test results across platforms.
11. Use a single CI/CD pipeline to trigger API, web, and mobile tests
12. Ensure the test framework supports multiple environments (e.g., dev, staging, production) for all platforms.
    For mobile testing, set up configurations for different OS versions (iOS, Android) and devices (real/emulator).

# 2.Propose a theoretical example of contract testing for an e-commerce application (or any other from your experience). What tools will you use and how will you implement this? 
#I have never used contract testing before, but I searched about it and this is what I would do
Theoretical Example of Contract Testing for an E-Commerce Application:
1. I would use Pact as a contract testing tool
2. Scenario: User has some items in the cart and should pay. We will have 2 contracts:
   1. The first contract is for the order, to verify what the Payment should provide. This test will verify that
   the order expects a specific contract from the payment
   2. The second contract is for the payment, will validate by ensuring it responds in the way the order expects.
      This test ensures that the payment correctly handles the contract by receiving the expected requests and
      providing the correct responses.
Objective:
Ensure that the backend API adheres to the agreed contract with the web and mobile applications. If the API contract changes, the consuming applications should not break unexpectedly.
   
Benefits
Prevents breaking changes between the API and its consumers.
Provides early feedback to both teams on compatibility issues.
Enables independent development of backend and frontend teams.