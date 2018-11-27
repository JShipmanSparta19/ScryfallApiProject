package com.sparta.jas;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ScryfallHTTPManager {
    private String baseURI;
    private String sets;
    private String cards;

    public ScryfallHTTPManager(){
        baseURI = "https://api.scryfall.com/";
    }

    public void setSets(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet requestSets = new HttpGet(baseURI + "sets");
            CloseableHttpResponse response = httpClient.execute(requestSets);
            sets = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSets(){
        return sets;
    }
}
