package com.cydeo.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestWithParameters {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
        RestAssured.baseURI = "http://54.91.11.180:8000";
    }

    /*   Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json
          And "Blythe" should be in response payload
       */

    @DisplayName("GET request to /api/spartans/{id} with 55")
    @Test
    public void test(){
         Response response = given().accept(ContentType.JSON)
                 .and().pathParams("id", 55)
                 .when().get("/api/spartans/{id}");

        //verify status code
         assertEquals(200, response.statusCode());
         //verify contentType
         assertEquals("application/json", response.contentType());
         //verify Blythe in the json payload/body
         assertTrue(response.body().asString().contains("Blythe"));

    }

     /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */

    @DisplayName("GET request /api/spartans/{id} Negative Test")
    @Test
    public void test2(){
        Response response = given().log().all().accept(ContentType.JSON)
                .pathParam("id", 500)
                .when().get("api/spartans/{id}");

        //verify statusCode 404
        assertEquals(404, response.statusCode());
        //verify contentType
        assertEquals("application/json", response.contentType());
        //verify Not Found in the json payload/body
        assertTrue(response.body().asString().contains("Not Found"));
    }

    /*
        Given accept type is Json
        And query parameter values are:
        gender|Female
        nameContains|e
        When user sends GET request to /api/spartans/search
        Then response status code should be 200
        And response content-type: application/json
        And "Female" should be in response payload
        And "Severus" should be in response payload
     */

    @DisplayName("GET request to /api/spartans/search with Query Params")
    @Test
    public void test3(){
        Response response = given().log().all().accept(ContentType.JSON)
                .and().queryParam("nameContains", "e")
                .and().queryParam("gender", "Female")
                .when().get("/api/spartans/search");

        //verify statusCode 200
        assertEquals(200, response.statusCode());
        //verify contentType
        assertEquals("application/json", response.contentType());
        //"Female" should be in response payload
        assertTrue(response.body().asString().contains("Female"));
        //"Severus" should be in response payload
        assertTrue(response.body().asString().contains("Severus"));

    }

    @DisplayName("GET request to /api/spartans/search with Queey Params (MAP)")
    @Test
    public void test4(){
        //create a map add query parameters
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("nameContains", "e");
        queryMap.put("gender","Female");

        Response response = given().accept(ContentType.JSON)
                .and().queryParams(queryMap)
                .when().get("/api/spartans/search");

        //verify statusCode
        assertEquals(200, response.statusCode());
        //verify contentType
        assertEquals("application/json", response.contentType());
        //verify "Female" should be in response payload
        assertTrue(response.body().asString().contains("Female"));
        //verify "Severus" should be in response payload
        assertTrue(response.body().asString().contains("Severus"));


    }




}
