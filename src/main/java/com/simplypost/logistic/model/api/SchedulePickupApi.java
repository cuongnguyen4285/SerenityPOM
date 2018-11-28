package com.simplypost.logistic.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SchedulePickupApi {
    @JsonProperty("merchant_code")
    private String merchant_code;
    @JsonProperty("pickup_details")
    private PickupDetailsApi pickup_details;
    @JsonProperty("ids")
    private List ids;

    public String getMerchantCode(){
        return merchant_code;
    }

    public SchedulePickupApi setMerchantCode(String merchant_code){
        this.merchant_code=merchant_code;
        return this;
    }

    public PickupDetailsApi getPickupDetails(){
        return pickup_details;
    }

    public SchedulePickupApi setPickupDetails(PickupDetailsApi pickup_details){
        this.pickup_details = pickup_details;
        return this;
    }

    public List getIds(){
        return ids;
    }

    public SchedulePickupApi setIds(List ids){
        this.ids = ids;
        return this;
    }

}
