package PojoClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Logout_User {
    String token;

        @Test(priority = 1)
        public void Login(){
            RestAssured.baseURI=Constant_API.base_url;
            RestAssured.basePath=Constant_API.login_end_point;

            PojoLogin login_pojo=new PojoLogin();
            login_pojo.setEmail("navin@gmail.com");
            login_pojo.setPassword("manisha@123");
            Response response = given().contentType(ContentType.JSON).log().all().body(login_pojo).post();
            token=response.then().extract().path("token");
            System.out.println("Token ="+token);
            response.prettyPrint();
            Assert.assertEquals(response.getStatusCode(), 200,"Status code mismatch");
        }
        @Test(priority = 2)
        public void LogoutUser(){
            RestAssured.baseURI= Constant_API.base_url;
            RestAssured.basePath=Constant_API.Logout_User;
            Response response=given().header("Authorization","Bearer "+token).log().all().post();
            response.prettyPrint();
            System.out.println(response.getStatusCode());
            Assert.assertEquals(response.statusCode(), 200,"Mismatch");
        }
    }
