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

    public JSONArray getCoreShortList(){
        JSONArray coreSetShortList = new JSONArray();
        for (Object set: coreSets) {
            JSONObject coreSet = (JSONObject) set;
            JSONObject coreSetShort = new JSONObject();
            coreSetShort.put("code", coreSet.get("code"));
            coreSetShort.put("name", coreSet.get("name"));
            coreSetShort.put("set_type", coreSet.get("set_type"));
            coreSetShortList.add(coreSetShort);
        }
        return coreSetShortList;
    }

    public JSONArray getExpansionShortList(){
        JSONArray expansionShortList = new JSONArray();
        for (Object set: expertLvExpansions) {
            JSONObject expansion = (JSONObject) set;
            JSONObject expansionShort = new JSONObject();
            expansionShort.put("code", expansion.get("code"));
            expansionShort.put("name", expansion.get("name"));
            expansionShort.put("set_type", expansion.get("set_type"));
            expansionShortList.add(expansionShort);
        }
        return expansionShortList;
    }
}
