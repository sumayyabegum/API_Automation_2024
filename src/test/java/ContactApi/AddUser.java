package ContactApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddUser {
    String token;
    @Test
    public void login()
    {
        //https://thinking-tester-contact-list.herokuapp.com/users/login
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users/login";
        RestAssured.defaultParser= Parser.JSON;
        Response resp = given().contentType(ContentType.JSON).log().all().body("{\n" +
                "    \"email\": \"timmer3@fake.com\",\n" +
                "    \"password\": \"myPassword\"\n" +
                "}").post();
        token = resp.then().extract().path("token");

        System.out.println("TOKEN: " + token);
        resp.prettyPrint();
    }

    @Test(priority = 2)
    public void newuser() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users";

        Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().body("{\n" +
                "    \"firstName\": \"Tesla\",\n" +
                "    \"lastName\": \"Users\",\n" +
                "    \"email\": \"test1@fake.com\",\n" +
                "    \"password\": \"myPassword\",\n" + "}").post();
        response.prettyPrint();
        System.out.println(response.getStatusCode());

    }
}

