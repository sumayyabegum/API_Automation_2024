package Restfull_Booker_API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_Createbooking {
        String token;
        @Test(priority =1)
        public void createToken() {

            RestAssured.baseURI=Restfull_Constant.base_url;
            RestAssured.basePath=Restfull_Constant.login_User;
            Restfull_Login login=new Restfull_Login();
            login.setUsername("admin");
            login.setPassword("password123");
            Response response=given().contentType(ContentType.JSON).log().all().body(login).post();
            token=response.then().extract().path("token");
            System.out.println("Token: "+token);
            response.prettyPrint();
            Assert.assertEquals(response.statusCode(), 200,"Status code mismatched");
        }
        @Test(priority = 2)
        public void createBooking() {
            RestAssured.baseURI = Restfull_Constant.base_url;
            RestAssured.basePath = Restfull_Constant.create_booking;

            Restfull_Fields field = new Restfull_Fields();

            field.setFirstname("Sumayya");
            field.setLastname("Mulla");
            field.setTotalprice(2000);
            field.setDepositpaid(true);
            field.setBookingdates("2023-04-01/2023-04-05");
            field.setAdditionalneeds("Extra pillows please");

            Response response = given().contentType(ContentType.JSON).log().all().body(field).post();
            response.prettyPrint();
            System.out.println("Status code : " + response.statusCode());
        }
    }
