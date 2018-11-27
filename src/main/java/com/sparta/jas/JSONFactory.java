package com.sparta.jas;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFactory {
    private JSONObject setsJSON;
    private JSONObject cardsJSON;

    public JSONObject getSetsJSON() {
        return setsJSON;
    }

    public void setSetsJSON(String sets) {
        JSONParser jsonParser = new JSONParser();
        try {
            setsJSON = (JSONObject) jsonParser.parse(sets);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getCardsJSON() {
        return cardsJSON;
    }

    public void setCardsJSON(String cards) {
        JSONParser jsonParser = new JSONParser();
        try {
            cardsJSON = (JSONObject) jsonParser.parse(cards);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
