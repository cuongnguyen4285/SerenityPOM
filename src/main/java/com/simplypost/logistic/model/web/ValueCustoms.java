package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by scorpion on 9/2/18.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "currencyCode",
//        "amount",
//})

public class ValueCustoms {

    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("amount")
    private String amount;

    public String getCurrencyCode(){
        return this.currencyCode;
    }

    public String getAmount(){
        return this.amount;
    }

    public ValueCustoms setCurrencyCode(String currencyCode){
        this.currencyCode = currencyCode;
        return this;
    }

    public ValueCustoms setAmount(String amount){
        this.amount = amount;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("currencyCode", currencyCode)
                .append("amount", amount)
                .toString();
    }

}
