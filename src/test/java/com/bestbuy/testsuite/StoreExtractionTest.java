package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtractionTest {
    /*
    http://localhost:3030/stores
     */

     /*
    http://localhost:3030/products

     */

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    // 1. Extract the limit
    @Test
    public void test1() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total
    @Test
    public void test2() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3.Extract the name of 5th store
    @Test
    public void test3() {
        String storeName = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The fifth store name is : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test4() {
        List<?> storeNames = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names are : " + storeNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test5() {
        List<?> storeId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store ids are :  " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }


    //6. Print the size of the data list
    @Test
    public void test6() {
        List<Integer> sizeOfData = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + sizeOfData.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 7. Get all the value of the store where store name = St Cloud

    @Test
    public void test7() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for store name 'St Cloud' are:  " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test8() {
        List<?> storeAddress = response.extract().path("data.findAll{it.name =='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store are: " + storeAddress);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test9() {
        List<HashMap<String, ?>> services = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test10() {
        List<HashMap<String, ?>> storeServices= response.extract().path("data.findAll{it.name == 'Windows Store'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services of the store where service name is Windows Store: " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //  11. Get all the storeId of all the store
    @Test
    public void test11() {
        List<Integer> storeId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store ids are : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }


    //12. Get id of all the store
    @Test
    public void test12() {
        List<?> id = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store ids are : " + id);
        System.out.println("------------------End of Test---------------------------");
    }


    //13. Find the store names Where state = ND
    @Test
    public void test13() {
        List<String> storeName = response.extract().path("data.findAll{it.state == 'ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name is : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }


    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14() {
        List<Integer> numberOfServices = response.extract().path("data[8].services");
        numberOfServices.size();

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The number of services for the store where store name Rochester are : " + numberOfServices.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test15() {
        List<?> createAt = response.extract().path("data.findAll{it.name == 'Windows Store'}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all services whose name = Windows Store is : " + createAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //  16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16() {
        List<HashMap<String, ?>> name = response.extract().path("data.findAll{it.name == 'Fargo'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services where store name Fargo is  : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //17. Find the zip of all the store
    @Test
    public void test17() {
        List<Integer> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("zip of all the store " + zip );
        System.out.println("------------------End of Test---------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test18() {
        List<Integer> zip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Zip of store name Roseville is :" + zip);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test19() {
        List<?> services = response.extract().path("data.findAll{it.services.name == 'Magnolia Home Theater'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store service detail of Mangolia Home Theater is : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

// 20. Find the lat of all the stores

    @Test
    public void test20() {
        List<Double> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The lat of all the stores  " + lat);
        System.out.println("------------------End of Test---------------------------");
    }
}
