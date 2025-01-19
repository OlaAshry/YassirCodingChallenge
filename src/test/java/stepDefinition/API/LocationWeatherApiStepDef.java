package stepDefinition.API;
import API.GetLocationWeather;
import Utilis.Config;
import io.cucumber.java.en.*;

public class LocationWeatherApiStepDef {
    private String apiKey;
    private String city;
    GetLocationWeather getLocationWeather = new GetLocationWeather();

    @Given("I have a valid API key")
    public void i_have_a_valid_api_key() {

        apiKey = Config.getWeatherValidApiKey();
    }

    @Given("I have an invalid API key")
    public void i_have_an_invalid_api_key() {
        apiKey = Config.getWeatherInvalidApiKey();
    }

    @When("I request weather for {string}")
    public void i_request_weather_for(String city) {
        getLocationWeather.requestForTheWeather(apiKey,city);
    }
    @Given("I have a weather API without an API key")
    public void iHaveAWeatherAPIWithoutAnAPIKey() {
        apiKey =Config.getWeatherNoApiKey();
    }

    @Then("I should get a {int} status code")
    public void i_should_get_a_status_code(int expectedStatusCode) {
        getLocationWeather.asserStatusValue(expectedStatusCode);
    }

    @And("the response should contain {string} in the location name")
    public void the_response_should_contain_in_the_location_name(String expectedCity) {
        getLocationWeather.assertLocationName(expectedCity);
    }

    @Then("I should see the response with error code {int} and error type {string}")
    public void i_should_see_the_response_with_error_code_and_error_type(int errorCode, String errorMessage) {
        getLocationWeather.requestResponseValidation(errorCode,errorMessage);
    }

    @When("I fetch weather information without a city")
    public void iFetchWeatherInformationWithoutACity() {
        city = "";
        getLocationWeather.requestForTheWeather(apiKey,city);

    }

    @When("I fetch weather information without a sending API key and also without a city")
    public void iFetchWeatherInformationWithoutASendingAPIKeyAndAlsoWithoutACity() {
        city ="";
        getLocationWeather.requestForTheWeather(apiKey,city);
    }
}
