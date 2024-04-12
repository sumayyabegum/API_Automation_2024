package hashmap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Deletecontact {
    String token;

    @Test(priority = 1)
    public void login() {
        //https://thinking-tester-contact-list.herokuapp.com/users/login
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users/login";//

        HashMap map=new HashMap<>();
        map.put("email","timmer4@fake.com");
        map.put("password","myPassword");
        Response resp = given().contentType(ContentType.JSON).log().all().body(map).post();
        token = resp.then().extract().path("token");

        System.out.println("TOKEN: " + token);
        resp.prettyPrint();
    }

    @Test(priority = 2)
    public void delete() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contacts/";

        Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().delete();
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
