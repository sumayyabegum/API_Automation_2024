package Restfull_Booker_API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_getBookingId_byDate {
    String token;
    @Test(priority = 1)
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
    public void getBookingIds(){
        RestAssured.baseURI=Restfull_Constant.base_url;
        RestAssured.basePath=Restfull_Constant.get_Id_byDate;
        Response response=given().contentType(ContentType.JSON).log().all().get();
        System.out.println("Status code: "+response.statusCode());
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200,"Status code mismatched");
    }
}
