package com.sparta.jas;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Random;

public class SetGenerator {
//    private SetList setList;
    private JSONArray coreSets;
    private JSONArray expansions;
    private Random random = new Random();
    private JSONArray chaosStandard = new JSONArray();

    public SetGenerator(JSONArray coreSets, JSONArray expansions){
        this.coreSets = coreSets;
        this.expansions = expansions;
    }

    private JSONObject getRandomCoreSet(){
        return (JSONObject) coreSets.get(random.nextInt(coreSets.size()));
    }

    private JSONObject getRandomExpansion(){
        return (JSONObject) expansions.get(random.nextInt(expansions.size()));
    }

    public JSONArray generateChaosStandard(){
        for (int i = 0; i < 2; i++) {
            JSONObject coreSet = getRandomCoreSet();
            if (!chaosStandard.contains(coreSet) && !coreSet.get("code").equals("fbb") && !coreSet.get("code").equals("sum")){
                chaosStandard.add(coreSet);
            } else {
                i--;
            }
        }
        for (int i = 0; i < 6; i++) {
            JSONObject expansion = getRandomExpansion();
            if (!chaosStandard.contains(expansion) && !expansion.get("code").equals("tsb")){
                chaosStandard.add(expansion);
            } else {
                i--;
            }
        }
        return chaosStandard;
    }

    public String generateScryfallLink(){
        String scryfallLink;
        StringBuilder scryfallLinkBuilder = new StringBuilder("https://scryfall.com/search?q=set%3A" + ((JSONObject) chaosStandard.get(0)).get("code"));
        for (int i = 1; i < 8; i++) {
            scryfallLinkBuilder.append("+or+set%3A").append(((JSONObject) chaosStandard.get(i)).get("code"));
        }
        scryfallLinkBuilder.append("&unique=cards&as=grid&order=name");
        scryfallLink = scryfallLinkBuilder.toString();
        return scryfallLink;
    }
}
