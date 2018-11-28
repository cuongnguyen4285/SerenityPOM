package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by scorpion on 26/6/17.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "codeType",
//        "codAmount"
//
//})
public class COD {
    @JsonProperty("codType")
    private String codType;
    @JsonProperty("codAmount")
    private String codAmount;

    public COD() {
    }

    public String getCodType() {
        return codType;
    }

    public String getCodAmount() {
        return codAmount;
    }

    public COD setCodType(String codType) {
        this.codType = codType;
        return this;
    }

    public COD setCodAmount(String codAmount) {
        this.codAmount = codAmount;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("codType", codType)
                .append("codAmount", codAmount)
                .toString();
    }
}
