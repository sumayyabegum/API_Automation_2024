package hashmap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Userlogin {

    String token;

    @Test
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
    public void AddContact() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contacts";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName",Utils.firstName());
        jsonObject.put("lastName",Utils.lastName());
        jsonObject.put("birthdate",Utils.birthdate());
        jsonObject.put("email",Utils.email());
        jsonObject.put("phone",Utils.phoneNumber());
        jsonObject.put("city",Utils.cityName());
        jsonObject.put("street1",Utils.streetName());
        jsonObject.put("street2",Utils.streetName());
        jsonObject.put("postalCode",Utils.postcode());
        jsonObject.put("country",Utils.country());
        jsonObject.put("stateProvince",Utils.state());


        Response response = given().header("Authorization","Bearer "+token)
                .contentType(ContentType.JSON).log().all().body(jsonObject).post();

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