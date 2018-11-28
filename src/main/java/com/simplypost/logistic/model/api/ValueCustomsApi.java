package com.simplypost.logistic.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ValueCustomsApi {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private String amount;

    public String getCurrency(){
        return this.currency;
    }

    public String getAmount(){
        return this.amount;
    }

    public ValueCustomsApi setCurrency(String currency){
        this.currency = currency;
        return this;
    }

    public ValueCustomsApi setAmount(String amount){
        this.amount = amount;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("currency", currency)
                .append("amount", amount)
                .toString();
    }
}
