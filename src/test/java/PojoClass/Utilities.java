package PojoClass;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Utilities {
        public static String firstName(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.name().firstName();
        }

        public static String lastName(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.name().lastName();
        }

        public static String birthDate(){
            return "2019-02-10";
        }

        public static String email(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.name().firstName()+"@testmail.com";
        }

        public static String phoneNumber(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.number().digits(10);
        }


        public static String street1(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.address().streetAddress();
        }

        public static String street2() {
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.address().streetName();
        }
        public static String city(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.address().city();
        }

        public static String stateProvince(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.address().state();
        }

        public static String postalCode(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.address().zipCode();
        }

        public static String country(){
            Faker faker=new Faker(new Locale("en-IND"));
            return faker.address().country();
        }

        public static String password(){
            return "mypassword@123";
        }

    }
