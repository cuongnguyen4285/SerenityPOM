package com.simplypost.logistic.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "contact_name",
        "phone_number",
        "email",
        "country_code",
        "country_name",
        "city",
        "address",
        "postcode"
})
public class ConsigneeDetailsApi {

    @JsonProperty("contact_name")
    private String contact_name;
    @JsonProperty("phone_number")
    private String phone_number;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private String address;
    @JsonProperty("country_code")
    private String country_code;
    @JsonProperty("country_name")
    private String country_name;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("postcode")
    private String postcode;

    private String date;

    public String getContactName() {
        return contact_name;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCountryCode(){
        return country_code;
    }

    public String getCountryName(){
        return country_name;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getDate(){ return date;}

    public ConsigneeDetailsApi setContactName(String contactName) {
        this.contact_name = contactName;
        return this;
    }

    public ConsigneeDetailsApi setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
        return this;
    }

    public ConsigneeDetailsApi setEmail(String email) {
        this.email = email;
        return this;
    }

    public ConsigneeDetailsApi setAddress(String address) {
        this.address = address;
        return this;
    }

    public ConsigneeDetailsApi setCountryCode(String country_code){
        this.country_code = country_code;
        return this;
    }

    public ConsigneeDetailsApi setCountryName(String country_name){
        this.country_name = country_name;
        return this;
    }

    public ConsigneeDetailsApi setCity(String city){
        this.city = city;
        return this;
    }

    public ConsigneeDetailsApi setState(String state){
        this.state = state;
        return this;
    }

    public ConsigneeDetailsApi setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public ConsigneeDetailsApi setDate(String date){
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(
                this).append("contactName", contact_name)
                .append("phone_number", phone_number)
                .append("email", email)
                .append("address", address)
                .append("postcode", postcode).toString();
    }

}
