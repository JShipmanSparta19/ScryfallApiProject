package com.sparta.jas;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class SetList {
    private JSONObject fullListJSON;
    private JSONArray fullList;
    private JSONArray coreSets = new JSONArray();
    private JSONArray expertLvExpansions = new JSONArray();

    public SetList(){
        ScryfallHTTPManager scryfallHTTPManager = new ScryfallHTTPManager();
        scryfallHTTPManager.setSets();
        JSONFactory jsonFactory = new JSONFactory();
        jsonFactory.setSetsJSON(scryfallHTTPManager.getSets());
        fullListJSON = jsonFactory.getSetsJSON();
        fullList = (JSONArray) fullListJSON.get("data");
    }

    public JSONArray getFullList() {
        return fullList;
    }

    public JSONArray getCoreSets() {
        return coreSets;
    }

    public void setCoreSets() {
        for (Object set :fullList) {
            if(set.toString().contains("\"set_type\":\"core\"")){
                coreSets.add(set);
            }
        }
    }

    public JSONArray getExpertLvExpansions() {
        return expertLvExpansions;
    }

    public void setExpertLvExpansions() {
        for (Object set :fullList) {
            if(set.toString().contains("\"set_type\":\"expansion\"")){
                expertLvExpansions.add(set);
            }
        }
    }
}
