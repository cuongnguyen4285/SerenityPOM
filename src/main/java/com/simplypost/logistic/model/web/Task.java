package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by scorpion on 26/6/17.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder(
//        "taskId",
//        "taskStatus"
//
//})

public class Task {
    @JsonProperty("merchantCode")
    private String merchantCode;
    @JsonProperty("pickupAddress")
    private String pickupAddress;
    @JsonProperty("pickupScheduleDate")
    private String pickupScheduleDate;
    @JsonProperty("pickupAssignedDate")
    private String pickupAssignedDate;
    @JsonProperty("totalOrders")
    private int totalOrders;
    @JsonProperty("totalWeight")
    private String totalWeight;
    @JsonProperty("assignedDriver")
    private String assignedDriver;
    @JsonProperty("failingReason")
    private String failingReason;
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("taskStatus")
    private String taskStatus;
    @JsonProperty("deliveries")
    private List<Delivery> deliveries;

    public String get_Id() {
        return _id;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public List<Delivery> getDeliveriesList() {
        return deliveries;
    }

    public String getMerchantCode(){
        return merchantCode;
    }

    public String getPickupAddress(){
        return pickupAddress;
    }

    public String getPickupScheduleDate(){
        return pickupScheduleDate;
    }

    public int getTotalOrders(){
        return totalOrders;
    }

    public String getTotalWeight(){
        return totalWeight;
    }

    public String getPickupAssignedDate(){
        return pickupAssignedDate;
    }

    public String getFailingReason(){
        return failingReason;
    }

    public String getAssignedDriver(){
        return assignedDriver;
    }

    public Task set_Id(String _id) {
        this._id = _id;
        return this;
    }

    public Task setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
        return this;
    }

    public Task setDeliveriesList(List<Delivery> deliveries) {
        this.deliveries = deliveries;
        return this;
    }

    public Task setMerchantCode(String merchantCode){
        this.merchantCode = merchantCode;
        return this;
    }

    public Task setPickupAddress(String pickupAddress){
        this.pickupAddress = pickupAddress;
        return this;
    }

    public Task setPickupSchedule(String pickupScheduleDate){
        this.pickupScheduleDate = pickupScheduleDate;
        return this;
    }

    public Task setTotalOrders(int totalOrders){
        this.totalOrders = totalOrders;
        return this;
    }

    public Task setTotalWeight(String totalWeight){
        this.totalWeight = totalWeight;
        return this;
    }

    public Task setPickupAssignedDate(String pickupAssignedDate){
        this.pickupAssignedDate = pickupAssignedDate;
        return this;
    }

    public Task setFailingReason(String failingReason){
        this.failingReason = failingReason;
        return this;
    }

    public Task setAssignedDriver(String assignedDriver){
        this.assignedDriver = assignedDriver;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("_id", _id)
                .append("taskStatus", taskStatus)
                .append("pickupAddress", pickupAddress)
                .append("pickupScheduleDate", pickupScheduleDate)
                .append("totalOrders", totalOrders)
                .append("pickupAssignedDate", pickupAssignedDate)
                .append("failingReason", failingReason)
                .append("assignedDriver", assignedDriver)
                .append("totalWeight", totalWeight)
                .toString();
    }
}
