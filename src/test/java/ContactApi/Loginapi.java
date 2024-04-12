package ContactApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

import static io.restassured.RestAssured.given;

public class Loginapi {
    String token;

    @Test
    public void login() {
        //https://thinking-tester-contact-list.herokuapp.com/users/login
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users/login";//
        Response resp = given().contentType(ContentType.JSON).log().all().body("{\n" +
                "    \"email\": \"timmer4@fake.com\",\n" +
                "    \"password\": \"myPassword\"\n" +
                "}").post();
        token = resp.then().extract().path("token");

        System.out.println("TOKEN: " + token);
        resp.prettyPrint();
    }

    @Test(priority = 2)
    public void AddContact() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contacts";

        Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().body("{\n" +
                "    \"firstName\": \"suman\",\n" +
                "    \"lastName\": \"sharmaya\",\n" +
                "    \"birthdate\": \"1972-01-01\",\n" +
                "    \"email\": \"jdoe@fake.com\",\n" +
                "    \"phone\": \"8005544555\",\n" +
                "    \"street1\": \"1 Main St.\",\n" +
                "    \"street2\": \"Apartment A\",\n" +
                "    \"city\": \"Anytown\",\n" +
                "    \"stateProvince\": \"KS\",\n" +
                "    \"postalCode\": \"12345\",\n" +
                "    \"country\": \"USA\"\n" +
                "}").post();

        response.prettyPrint();
        System.out.println(response.getStatusCode());

    }

    @Test(priority = 3)
    public void GetContact() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contacts";

        Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().get();
        response.prettyPrint();
        System.out.println(response.getStatusCode());

    }
    @Test(priority = 4)
    public void GetContacts()
    {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contacts/";
        Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().get();
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
