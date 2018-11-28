package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Validation {

    @JsonProperty("trackingId")
    private String trackingId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("noOfScanned")
    private String noOfScanned;
    @JsonProperty("errorMessage")
    private String errorMessage;

    public String getTrackingId() {
        return trackingId;
    }

    public Validation setTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Validation setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDriver() {
        return driver;
    }

    public Validation setDriver(String driver) {
        this.driver = driver;
        return this;
    }

    public String getNoOfScanned() {
        return noOfScanned;
    }

    public Validation setNoOfScanned(String noOfScanned) {
        this.noOfScanned = noOfScanned;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Validation setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("trackingId", trackingId)
                .append("status", status)
                .append("driver", driver)
                .append("noOfScanned", noOfScanned)
                .append("errorMessage", errorMessage)
                .toString();
    }

}
