package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by scorpion on 25/6/17.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "userName",
//        "password",
//        "name",
//        "code"
//})
public class Merchant {

    @JsonProperty("userName")
    private String userName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;
    @JsonProperty("code")
    private String code;

    public Merchant(){}

    public String getName(){
        return name;
    }

    public String getUserName(){return userName;}

    public String getPassword(){return password;}

    public String getCode(){return code;}

    public Merchant setName(String name){
        this.name = name;
        return this;
    }

    public Merchant setUserName(String userName){
        this.userName = userName;
        return this;
    }

    public Merchant setPassword(String password){
        this.password = password;
        return this;
    }

    public Merchant setCode(String code){
        this.code = code;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("code", code)
                .append("name", name)
                .append("username", userName)
                .append("password", password)
                .toString();
    }
}
