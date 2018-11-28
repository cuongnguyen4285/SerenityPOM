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
//        "pickupNote",
//        "pickupReadyTime",
//        "pickupCloseTime"
//})
public class Sender {

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
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("unitNo")
    private String unitNo;
    @JsonProperty("city")
    private String city;
    @JsonProperty("buildingName")
    private String buildingName;
    @JsonProperty("date")
    private String date;
    @JsonProperty("timeSlot")
    private String timeSlot;
    @JsonProperty("pickupNote")
    private String pickupNote;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("pickupReadyTime")
    private String pickupReadyTime;
    @JsonProperty("pickupCloseTime")
    private String pickupCloseTime;

    public Sender() {
    }

    public String getUnitNo() {
        return unitNo;
    }

    public String getCountry(){
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getPickupNote(){
        return pickupNote;
    }

    public String getPickupReadyTime() {
        return pickupReadyTime;
    }

    public String getPickupCloseTime() {
        return pickupCloseTime;
    }


    public Sender setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
        return this;
    }

    public Sender setStreet(String street) {
        this.street = street;
        return this;
    }

    public Sender setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public Sender setEmail(String email) {
        this.email = email;
        return this;
    }

    public Sender setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Sender setName(String name) {
        this.name = name;
        return this;
    }

    public Sender setDate(String date) {
        this.date = date;
        return this;
    }

    public Sender additionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    public Sender setCountry(String country){
        this.country = country;
        return this;
    }

    public Sender setCity(String city) {
        this.city = city;
        return this;
    }

    public Sender setBuildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }

    public Sender setUnitNo(String unitNo) {
        this.unitNo = unitNo;
        return this;
    }

    public Sender setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
        return this;
    }

    public Sender setPickupNote(String pickupNote) {
        this.pickupNote = pickupNote;
        return this;
    }

    public Sender setPickupReadyTime(String pickupReadyTime){
        this.pickupReadyTime = pickupReadyTime;
        return this;
    }

    public Sender setPickupCloseTime(String pickupCloseTime){
        this.pickupCloseTime = pickupCloseTime;
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
                .append("country", country)
                .append("city", city)
                .append("country", country)
                .append("buildingName", buildingName)
                .append("date", date)
                .append("deliveryNote", pickupNote)
                .append("timeSlot", timeSlot)
                .toString();
    }
}
