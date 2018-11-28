package com.simplypost.logistic.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ShipmentsApi {

    @JsonProperty("shipments")
    private List<DeliveryApi> shipments;

    public List<DeliveryApi> getShipments(){
        return shipments;
    }

    public ShipmentsApi setShipments(List<DeliveryApi> shipments){
        this.shipments = shipments;
        return this;
    }
}
