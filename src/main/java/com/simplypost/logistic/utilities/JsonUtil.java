package com.simplypost.logistic.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtil {

    public static JSONObject convertToJsonObject(Response response){
        JSONObject json = null;
        try{
            JSONParser parser = new JSONParser();
            json = (JSONObject) parser.parse(response.asString());

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return json;
    }

    public static JSONArray convertToJsonArray(Response response){
        JSONArray json = null;
        try{
            JSONParser parser = new JSONParser();
            json = (JSONArray) parser.parse(response.asString());

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return json;
    }

    //https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
}