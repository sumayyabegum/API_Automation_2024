package PojoClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Update_Contacts {
        String token;

      @Test(priority = 1)
        public void Login() {
            RestAssured.baseURI = Constant_API.base_url;
            RestAssured.basePath = Constant_API.login_end_point;

            PojoLogin login_pojo = new PojoLogin();
            login_pojo.setEmail("timmer@fake.com");
            login_pojo.setPassword("myPassword");

            Response response = given().contentType(ContentType.JSON).log().all().body(login_pojo).post();
            token = response.then().extract().path("token");
            System.out.println("Token: " + token);
            response.prettyPrint();
            Assert.assertEquals(response.statusCode(), 200, "Status code mismatched");
        }

        @Test(priority = 2)
        public void UpdateContact_patch() {
            RestAssured.baseURI = Constant_API.base_url;
            RestAssured.basePath = Constant_API.Update_contact;

           PojoContacts contact_pojo = new PojoContacts();

            contact_pojo.setFirstName(Utilities.firstName());

            Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).log().all().body(contact_pojo).patch();
            response.prettyPrint();
            System.out.println("StatusCode : " + response.statusCode());

            Assert.assertEquals(response.statusCode(), 201, "Status code mismatched");

        }

    }
