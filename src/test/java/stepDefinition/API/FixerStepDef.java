package stepDefinition.API;
import API.GetSpecificCurrenciesRate;
import Utilis.Config;
import io.cucumber.java.en.*;

public class FixerStepDef {
    private String fixerApiKey;
    String symbols = "";
    GetSpecificCurrenciesRate getSpecificCurrenciesRate = new GetSpecificCurrenciesRate();

    @Given("I have a valid Fixer API key")
    public void i_have_a_valid_Fixer_api_key() {

        fixerApiKey = Config.getFixerValidApiKey();
    }

    @Given("I have an invalid Fixer API key")
    public void i_have_an_invalid_api_key() {
        fixerApiKey = Config.getFixerInvalidApiKey();
    }

    @Given("I make a request without Fixer API key")
    public void i_make_a_request_without_an_api_key() {
        fixerApiKey = Config.getFixerNoApiKey();
    }

    @When("I request latest rates for symbols {string}")
    public void i_request_latest_rates_for_symbols(String symbols) {
        getSpecificCurrenciesRate.requestForSpecificCurrenciesRate(fixerApiKey,symbols);
    }
    @Then("I should get a {int} status code For Fixer endpoint")
    public void iShouldGetAStatusCodeForFixerEndpoint(int expectedStatusCode) {

        getSpecificCurrenciesRate.asserStatusValue(expectedStatusCode);
    }

    @When("I request latest rates without symbols")
    public void i_request_latest_rates_without_symbols() {
        getSpecificCurrenciesRate.requestForSpecificCurrenciesRate(fixerApiKey,symbols);
    }

    @Then("the response should contain rates for {string}, {string}, and {string}")
    public void the_response_should_contain_rates_for(String currency1, String currency2, String currency3) {

        getSpecificCurrenciesRate.assertResponseRate(currency1,currency2,currency3);
    }

    @Then("I should see the response for Fixer endpoint with error code {int} and error type {string}")
    public void iShouldSeeTheResponseForFixerEndpointWithErrorCodeAndErrorType(int errorCode, String errorMessage) {
        getSpecificCurrenciesRate.requestResponseValidation(errorCode,errorMessage);
    }


    @Then("the response should contain rates for default currencies")
    public void the_response_should_contain_rates_for_default_currencies() {
        getSpecificCurrenciesRate.validationDefaultCurrency();
    }



}
