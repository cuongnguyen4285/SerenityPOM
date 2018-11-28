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
        "address",
        "postcode",
        "unit",
        "date",
        "time_window",
        "fullAddress"
})
public class PickupDetailsApi {

    @JsonProperty("contact_name")
    private String contact_name;
    @JsonProperty("phone_number")
    private String phone_number;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private String address;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("date")
    private String date;
    @JsonProperty("time_window")
    private TimeWindowApi time_window;
    @JsonProperty("fullAddress")
    private String fullAddress;

    private String timeSlot;
    private String pickupNote;

    public String getContactName() {
        return contact_name;
    }

    public PickupDetailsApi setContactName(String contactName) {
        this.contact_name = contactName;
        return this;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public PickupDetailsApi setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PickupDetailsApi setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PickupDetailsApi setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public PickupDetailsApi setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public PickupDetailsApi setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getDate() {
        return date;
    }

    public PickupDetailsApi setDate(String date) {
        this.date = date;
        return this;
    }

    public TimeWindowApi getTimeWindow() {
        return time_window;
    }

    public PickupDetailsApi setTimeWindow(TimeWindowApi time_window) {
        this.time_window = time_window;
        return this;
    }

    public String getPickupNote() {
        return pickupNote;
    }

    public PickupDetailsApi setPickupNote(String pickupNote) {
        this.pickupNote = pickupNote;
        return this;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public PickupDetailsApi setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
        return this;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public PickupDetailsApi setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("contactName", contact_name)
                .append("phoneNumber", phone_number)
                .append("setEmail", email)
                .append("address", address)
                .append("postcode", postcode)
                .append("date", date)
                .append("timeWindow", time_window).toString();
    }

}



