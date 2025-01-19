package API;

import Utilis.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class GetLocationWeather {

    private Response response;
    public void requestForTheWeather(String apiKey, String city){
        baseURI = Config.getWeatherBaseUrl();
        response = RestAssured.given()
                .baseUri(baseURI)
                .basePath("/current")
                .queryParam("access_key", apiKey)
                .queryParam("query", city)
                .get();
        response.prettyPrint();
    }

    public void asserStatusValue(int expectedStatusCode){
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    public void assertLocationName(String expectedCity){
        response.then().body("location.name", equalTo(expectedCity));
    }



    public void requestResponseValidation(int errorCode,String errorMessage)
    {
        response.then().assertThat().body("error.code", equalTo(errorCode));
        response.then().assertThat().body("error.type", equalTo(errorMessage));
    }

}
