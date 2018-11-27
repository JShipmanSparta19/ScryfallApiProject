package com.sparta.jas;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Before
    public void setup(){
        baseURI = "https://api.scryfall.com/";
//        basePath = "sets/";
//        port = 443;
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void ensureCorrectReturn()
    {
        get("sets")
                .then()
                .statusCode(200)
                .body("data.object", everyItem(equalTo("set")))
                .body("data.code*.length()", everyItem(greaterThanOrEqualTo(3)));
    }
}
