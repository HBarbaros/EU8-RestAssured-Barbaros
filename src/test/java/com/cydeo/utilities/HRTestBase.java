package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class HRTestBase {

    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we don't need to type each http method.
        RestAssured.baseURI = "http://54.91.11.180:1000/ords/hr";

        //get ip from configurations
        String dbUrl = "jdbc:oracle:thin:@54.91.11.180:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        //DBUtils.createConnection(dbUrl, dbUsername, dbPassword);

    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }


}
