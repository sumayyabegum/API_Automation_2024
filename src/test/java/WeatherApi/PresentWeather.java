package WeatherApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PresentWeather {
    String apiKey="6924a1ee581daf9703f6f11fc35336a8";
    double latitude=12.934533;
    double longitude=77.626579;
    @Test
    public  void getpresentWeather(){
        RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
        Response response=given().contentType(ContentType.JSON)
                .queryParam("lat",latitude)
                .queryParam("lon",longitude)
                .queryParam("appid",apiKey)
                .log().all().get();
        System.out.println("Present weather");
        response.prettyPrint();
        System.out.println("Status Code:" + response.getStatusCode());
    }
}
