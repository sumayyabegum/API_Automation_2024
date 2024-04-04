package ContactApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Updatecontact {
    String token;

    @Test
    public void login() {
        //https://thinking-tester-contact-list.herokuapp.com/users/login
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users/login";//
        Response resp = given().contentType(ContentType.JSON).log().all().body("{\n" +
                "    \"email\": \"timmer3@fake.com\",\n" +
                "    \"password\": \"myPassword\"\n" +
                "}").post();
        token = resp.then().extract().path("token");

        System.out.println("TOKEN: " + token);
        resp.prettyPrint();
    }

    @Test(priority = 2)
    public void update() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contacts/";

        Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().body("{\n" +
                "    \"firstName\": \"sana\",\n" +
                "    \"lastName\": \"shishi\",\n" +
                "    \"birthdate\": \"1970-01-01\",\n" +
                "    \"email\": \"jdoe@fake.com\",\n" +
                "    \"phone\": \"8115544555\",\n" +
                "    \"street1\": \"1 Main St.\",\n" +
                "    \"street2\": \"Apartment A\",\n" +
                "    \"city\": \"Anytown\",\n" +
                "    \"stateProvince\": \"KS\",\n" +
                "    \"postalCode\": \"12345\",\n" +
                "    \"country\": \"USA\"\n" +
                "}").put();

        response.prettyPrint();
        System.out.println(response.getStatusCode());

    }
}
