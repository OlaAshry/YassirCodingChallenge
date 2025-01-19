package API;

import Utilis.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.NotActiveException;
import java.util.Currency;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class GetSpecificCurrenciesRate {
    private Response response;
    public void requestForSpecificCurrenciesRate(String apiKey, String symbols){
        baseURI = Config.getFixerBaseUrl();
        response = RestAssured.given()
                .baseUri(baseURI)
                .queryParam("access_key", apiKey)
                .queryParam("symbols", symbols)
                .get();
        response.prettyPrint();
    }


    public void asserStatusValue(int expectedStatusCode){
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    public void assertResponseRate(String currency1, String currency2, String currency3){
        // Validate each currency exists in the "rates" field
        System.out.println(response.asString());
        response.then().body("rates." + currency1, notNullValue());
        response.then().body("rates." + currency2, notNullValue());
        response.then().body("rates." + currency3, notNullValue());
    }



    public void requestResponseValidation(int errorCode,String errorMessage)
    {
        response.then().assertThat().body("error.code", equalTo(errorCode));
        response.then().assertThat().body("error.type", equalTo(errorMessage));
    }

    public void validationDefaultCurrency()
    {
        response.then().assertThat().body("rates.", notNullValue());
    }
}
