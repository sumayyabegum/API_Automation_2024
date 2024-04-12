package ContactApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Getuser {
    String token;

    @Test
    public void login() {
        //https://thinking-tester-contact-list.herokuapp.com/users/login
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users/login";


        HashMap map=new HashMap<>();
        map.put("email","timmer4@fake.com");
        map.put("password","myPassword");
        Response resp = given().contentType(ContentType.JSON).log().all().body(map).post();
        token = resp.then().extract().path("token");

        System.out.println("TOKEN: " + token);
        resp.prettyPrint();
    }

    @Test(priority = 2)
    public void userget() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users/me";

        Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().get();
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
