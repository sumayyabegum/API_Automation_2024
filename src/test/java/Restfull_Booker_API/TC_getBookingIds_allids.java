package Restfull_Booker_API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_getBookingIds_allids {
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
        RestAssured.basePath=Restfull_Constant.get_bookingIds;
        Response response=given().contentType(ContentType.JSON).log().all().get();
        System.out.println("Status code: "+response.statusCode());
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200,"Status code mismatched");
    }
}

/**"bookingid": 92
 },
 {
 "bookingid": 59
 },
 {
 "bookingid": 93
 },
 {
 "bookingid": 32
 },
 {
 "bookingid": 3
 },
 {
 "bookingid": 41
 },
 {
 "bookingid": 99
 },
 {
 "bookingid": 79
 },
 {
 "bookingid": 39
 },
 {
 "bookingid": 42
 },
 {
 "bookingid": 25
 },
 {
 "bookingid": 52
 },
 {
 "bookingid": 88
 },
 {
 "bookingid": 114
 },*/
