package com.simplypost.logistic.platform.api;

import com.google.gson.Gson;
import com.simplypost.logistic.constants.ApiEndPoints;
import com.simplypost.logistic.model.api.DeliveryApi;
import com.simplypost.logistic.utilities.SerenityApiUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CreateOrderStepApi {

    Response response;

    @Step("Create an order")
    public CreateOrderStepApi createOrder(String token, DeliveryApi delivery){
        response = SerenityRest.rest()
                .given()
                .headers(ApiEndPoints.AUTHORIZATION,"JWT "+token)
                .contentType(ApiEndPoints.APPLICATION_JSON)
                .when()
                .log().all()
                .body(new Gson().toJson(delivery))
                .post(SerenityApiUtil.getApiUrl()+ ApiEndPoints.CREATE_ORDER)
                .then().extract().response();
        return this;
    }

    @Step("Get tracking Id")
    public String getTrackingID(){
        return JsonPath.from(response.asString()).getString(ApiEndPoints.TRACKING_ID);
    }

    @Step("Get order reference")
    public String getOrderRef(){
        return JsonPath.from(response.asString()).getString(ApiEndPoints.REFERENCE_NUMBER);
    }

}