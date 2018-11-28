package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by scorpion on 26/6/17.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "displayName",
//        "code"
//
//})
public class DeliveryStatus {

    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("code")
    private String code;

    public String getDisplayName() {
        return displayName;
    }

    public DeliveryStatus setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getCode() {
        return code;
    }

    public DeliveryStatus setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("displayName", displayName)
                .append("code", code)
                .toString();
    }
    
}
