package ContactApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Logoutuser {
    String token;
    @Test
    public void login() {
        //https://thinking-tester-contact-list.herokuapp.com/users/login
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users/login";
        Response resp = given().contentType(ContentType.JSON).log().all().body("{\n" +
                "    \"email\": \"timmer4@fake.com\",\n" +
                "    \"password\": \"myPassword\"\n" +
                "}").post();
        token = resp.then().extract().path("token");

        System.out.println("TOKEN: " + token);
        resp.prettyPrint();
    }

    @Test(priority = 2)
    public void logout() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/users/logout";

        Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().post();
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}

