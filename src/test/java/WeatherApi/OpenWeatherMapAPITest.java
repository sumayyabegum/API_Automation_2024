package WeatherApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class OpenWeatherMapAPITest {

    // Set your API key here
    String apiKey = "6924a1ee581daf9703f6f11fc35336a8";

    @Test
    public void testGetWeatherData() {
        RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
        // Define city name
        String cityName = "America";

        // Perform API request and get response
        Response response = given().contentType(ContentType.JSON)
                .queryParam("q", cityName)
                .queryParam("appid", apiKey)
                //.log().all().get();
                .when()
                .get(baseURI)
                .then()
                .extract().response();

        // Verify status code
        //int statusCode = response.getStatusCode();
        //Assert.assertEquals(statusCode, 200, "Status code is not 200");

        // Verify response body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        response.prettyPrint();
        System.out.println("Status Code:"+response.getStatusCode());

    }
}

