package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by scorpion on 26/6/17.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "cancelReason",
//        "failedPickupReason"
//
//})
public class Reason {

    @JsonProperty("cancelReason")
    private String cancelReason;
    @JsonProperty("failedPickupReason")
    private String failedPickupReason;
    @JsonProperty("failedDeliveryReason")
    private String failedDeliveryReason;

    public String getCancelReason() {
        return cancelReason;
    }

    public String getFailedPickupReason() {
        return failedPickupReason;
    }

    public String getFailedDeliveryReason() {
        return failedDeliveryReason;
    }

    public Reason setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
        return this;
    }

    public Reason setFailedPickupReason(String failedPickupReason) {
        this.failedPickupReason = failedPickupReason;
        return this;
    }

    public Reason setFailedDeliveryReason(String failedDeliveryReason) {
        this.failedDeliveryReason = failedDeliveryReason;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("failedPickupReason", failedPickupReason)
                .append("cancelReason", cancelReason)
                .toString();
    }
}
