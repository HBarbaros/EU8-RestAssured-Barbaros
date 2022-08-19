package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;


public class SpartanTestBase {

    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "http://54.91.11.180:8000";


        String dbUrl = "jdbc:oracle:thin:@54.91.11.180:1521:XE";
        String dbUsername = "SP";
        String dbPassword = "SP";

        //DBUtils.createConnection(dbUrl, dbUsername, dbPassword);
    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }

}
