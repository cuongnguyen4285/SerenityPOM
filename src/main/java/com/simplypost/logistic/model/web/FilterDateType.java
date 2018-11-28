package com.simplypost.logistic.model.web;

/**
 * Created by scorpion on 16/5/18.
 */
public enum FilterDateType {

    CREATED_DATE("Created date"),
    HUB_ARRIVAL_DATE("Hub arrival date"),
    SCHEDULED_PICKUP_DATE("Scheduled pickup date"),
    REQUESTED_DELIVERY_DATE("Requested delivery date"),
    PICKED_UP_DATE("Picked up date"),
    DELIVERED_DATE("Delivered date");

    private final String dateType;

    FilterDateType(final String dateType){
        this.dateType = dateType;
    }

    @Override
    public String toString(){
        return dateType;
    }

}
