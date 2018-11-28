package com.simplypost.logistic.utilities;

/**
 * Created by scorpion on 29/11/17.
 */
public class SerenityApiUtil {

    public static String getApiUrl(){
        return SerenityUtil.getEnv("api.url");
    }

    public static String getOpenApiUrl(){
        return SerenityUtil.getEnv("open.api.url");
    }
}
