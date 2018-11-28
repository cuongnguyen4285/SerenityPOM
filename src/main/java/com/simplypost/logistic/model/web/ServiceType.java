package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by scorpion on 26/6/17.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "type",
//        "name",
//        "code",
//        "sla"
//})

public class ServiceType {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private String code;
    @JsonProperty("sla")
    private int sla;

    public String getType() {
        return type;
    }


    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getSla(){
        return sla;
    }

    public ServiceType setType(String type) {
        this.type = type;
        return this;
    }

    public ServiceType setName(String name) {
        this.name = name;
        return this;
    }

    public ServiceType setCode(String code) {
        this.code = code;
        return this;
    }

    public ServiceType setSla(int sla){
        this.sla = sla;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("type", type)
                .append("name", name)
                .append("code", code)
                .append("sla", sla)
                .toString();
    }

}
