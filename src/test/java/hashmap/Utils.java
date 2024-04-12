package hashmap;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Utils {
    public static  String firstName(){
        Faker faker  = new Faker(new Locale("en-IND"));
        return faker.name().firstName();
    }

    public static  String lastName(){
        Faker faker  = new Faker(new Locale("en-IND"));
        return faker.name().lastName();
    }

    public static  String birthdate(){
        return "1972-01-01";
    }

    public static  String email(){
        Faker faker  = new Faker(new Locale("en-IND"));
        return faker.name().firstName()+"@test1mail.com";
    }
    public static  String phoneNumber(){
        Faker faker  = new Faker();
        return faker.number().digits(10);
    }

    public static  String streetName(){
        Faker faker  = new Faker(new Locale("en-IND"));
        return faker.address().streetName();
    }


    public static  String cityName(){
        Faker faker  = new Faker(new Locale("en-IND"));
        return faker.address().city();
    }

    public static  String postcode(){
        Faker faker  = new Faker();
        return faker.address().zipCode();
    }


    public static  String country(){
        Faker faker  = new Faker();
        return faker.address().country();
    }

    public static  String state(){
        Faker faker  = new Faker();
        return faker.address().state();
    }


}
