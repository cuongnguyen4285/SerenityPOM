package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scorpion on 26/6/17.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "name",
//        "fullAddress",
//        "street",
//        "zip",
//        "email",
//        "phone",
//        "unitNo",
//        "city",
//        "state",
//        "country",
//        "buildingName",
//        "date",
//        "deliveryNote"
//})
public class Receiver {

    @JsonProperty("name")
    private String name;
    @JsonProperty("fullAddress")
    private String fullAddress;
    @JsonProperty("street")
    private String street;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("unitNo")
    private String unitNo;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("buildingName")
    private String buildingName;
    @JsonProperty("date")
    private String date;
    @JsonProperty("deliveryNote")
    private String deliveryNote;


    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Receiver() {
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getState(){
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getDate() {
        return date;
    }

    public String getDeliveryNote(){
        return deliveryNote;
    }

    public Receiver setName(String name) {
        this.name = name;
        return this;
    }

    public Receiver setEmail(String email) {
        this.email = email;
        return this;
    }

    public Receiver setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Receiver setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
        return this;
    }

    public Receiver additionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    public Receiver setCity(String city) {
        this.city = city;
        return this;
    }

    public Receiver setState(String state){
        this.state = state;
        return this;
    }

    public Receiver setCountry(String country) {
        this.country = country;
        return this;
    }

    public Receiver setStreet(String street) {
        this.street = street;
        return this;
    }

    public Receiver setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public Receiver setUnitNo(String unitNo) {
        this.unitNo = unitNo;
        return this;
    }

    public Receiver setDate(String date) {
        this.date = date;
        return this;
    }

    public Receiver setBuildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }

    public Receiver setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("name", name)
                .append("fullAddress", fullAddress)
                .append("street", street)
                .append("email", email)
                .append("phone", phone)
                .append("unitNo", unitNo)
                .append("city", city)
                .append("state", state)
                .append("country", country)
                .append("buildingName", buildingName)
                .append("date", date)
                .append("deliveryNote", deliveryNote)
                .toString();
    }
}
