package com.simplypost.logistic.utilities;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.guice.ThucydidesModule;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebElement;

public class SerenityUtil {

    private static EnvironmentVariables evs;

    public static String getEnv(String key) {
        if (evs == null) {
            evs = (new ThucydidesModule()).provideEnvironmentVariables();
        }
        return evs.getProperty(key) == null ? "" : evs.getProperty(key);
    }

    public static String getIssue() {
        return "";
        //return StepEventBus.getEventBus().getBaseStepListener().getTestOutcomes().get(0).getIssueKeys().get(0);
    }

    public static String getMongoURL(){return getEnv("mongo.url");}

    public static String getMongoPort(){return getEnv("mongo.port");}

    public static String getMongoUserName(){return getEnv("mongo.userName");}

    public static String getMongoPassword(){return getEnv("mongo.password");}

    public static String getMongoDbName(){return getEnv("mongo.dbName");}

    public static String getBaseUrl() {
        return getEnv("base.url");
    }

    public static String getHttpsBaseUrl() {
        String baseURL = SerenityUtil.getBaseUrl();
        if (!baseURL.contains("https")) {
            return baseURL.replaceAll("http", "https");
        }
        return baseURL;
    }

    public static Converter<WebElement, String> toTextValues() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}
