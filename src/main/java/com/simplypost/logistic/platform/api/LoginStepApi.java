package com.simplypost.logistic.platform.api;

import com.simplypost.logistic.constants.ApiEndPoints;
import com.simplypost.logistic.utilities.SerenityApiUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import sun.misc.BASE64Encoder;

public class LoginStepApi {

    Response response;

    @Step("Login userName {0} and password {1} to merchant portal")
    public LoginStepApi login(String userName, String password){
        String auth = userName + ":" + password;
        String anthEncode = new BASE64Encoder().encode(auth.getBytes());
        response = SerenityRest.rest()
                .given()
                .header(ApiEndPoints.AUTHORIZATION,"Basic " + anthEncode)
                .contentType(ApiEndPoints.APPLICATION_JSON)
                .when()
                .post(SerenityApiUtil.getApiUrl()+ ApiEndPoints.MERCHANT_LOGIN)
                .then().extract().response();
        return this;

    }

    @Step("Get token")
    public String getToken(){
        return JsonPath.from(response.asString()).getString("token");
    }
}
