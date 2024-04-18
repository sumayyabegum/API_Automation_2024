package PojoClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_Add_Contacts {
    String token;
        @Test(priority = 1)
        public void Login(){
            RestAssured.baseURI=Constant_API.base_url;
            RestAssured.basePath=Constant_API.login_end_point;

            PojoLogin login_pojo=new PojoLogin();
            login_pojo.setEmail("timmer@fake.com");
            login_pojo.setPassword("myPassword");

            Response response=given().contentType(ContentType.JSON).log().all().body(login_pojo).post();
            token = response.then().extract().path("token");
            System.out.println("Token: "+token);
            response.prettyPrint();
            Assert.assertEquals(response.statusCode(), 200,"Status code mismatched");
        }
        @Test(priority=2)
        public void AddContact(){
            RestAssured.baseURI=Constant_API.base_url;
            RestAssured.basePath=Constant_API.add_contact;

            String Country=Utilities.country();

          PojoContacts contact_pojo=new PojoContacts();

            contact_pojo.setFirstName(Utilities.firstName());
            contact_pojo.setLastName(Utilities.lastName());
            contact_pojo.setBirthdate(Utilities.birthDate());
            contact_pojo.setEmail(Utilities.email());
            contact_pojo.setPhone(Utilities.phoneNumber());
            contact_pojo.setStreet1(Utilities.street1());
            contact_pojo.setStreet2(Utilities.street2());
            contact_pojo.setCity(Utilities.city());
            contact_pojo.setStateProvince(Utilities.stateProvince());
            contact_pojo.setPostalCode(Utilities.postalCode());
            contact_pojo.setCountry(Country);

            Response response=given().header("Authorization","Bearer "+token).contentType(ContentType.JSON).log().all().body(contact_pojo).post();
            response.prettyPrint();
            System.out.println("StatusCode : "+response.statusCode());

            String COUNTRY=response.then().extract().path("country");
            Assert.assertEquals(COUNTRY, Country,"Country mismatch");
            Assert.assertEquals(response.statusCode(), 201,"Status code mismatched");

        }

    }
