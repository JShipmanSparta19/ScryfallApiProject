package com.sparta.jas;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    SetGenerator setGenerator;
    JSONArray chaosStandard;


    @Before
    public void setup(){
        baseURI = "https://api.scryfall.com/";
        SetList setList = new SetList();
        setList.setCoreSets();
        setList.setExpertLvExpansions();
        setGenerator = new SetGenerator(setList.getCoreShortList(), setList.getExpansionShortList());
        chaosStandard = setGenerator.generateChaosStandard();
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

    @Test
    public void ensureFormatGeneratedCorrectly(){
        Assert.assertEquals(8, chaosStandard.size());
        for (int i = 0; i < 2; i++) {
            Assert.assertEquals("core", ((JSONObject) chaosStandard.get(i)).get("set_type"));
        }
        for (int i = 2; i < 8; i++) {
            Assert.assertEquals("expansion", ((JSONObject) chaosStandard.get(i)).get("set_type"));
        }
    }

    @Test
    public void noDupes(){
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 8; j++) {
                Assert.assertNotEquals(((JSONObject) chaosStandard.get(i)).get("code"), ((JSONObject) chaosStandard.get(j)).get("code"));
                Assert.assertNotEquals(((JSONObject) chaosStandard.get(i)).get("name"), ((JSONObject) chaosStandard.get(j)).get("name"));
            }
        }
    }
}
