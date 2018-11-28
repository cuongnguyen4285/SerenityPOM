package com.simplypost.logistic.model.web;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by scorpion on 26/6/17.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "merchant",
        "_id",
        "refId",
        "orderRef",
        "isCrossBorder",
        "quantity",
        "cod",
        "valueCustoms",
        "sender",
        "receiver",
        "serviceType",
        "deliveryFee",
        "tax",
        "grandTotal",
        "totalWeight",
        "handlingFee",
        "deliveryStatus",
        "isOrderRefForConnote",
        "isNonPickup",
        "isDropOffDateFollowSLA",
        "isMultiplePickupLocation",
        "isServiceTypeDefinedInCSV",
        "parcels",
        "reason",
        "task"
})

public class Delivery {
    @JsonProperty("merchant")
    private Merchant merchant;
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("refId")
    private String refId;
    @JsonProperty("orderRef")
    private String orderRef;
    @JsonProperty("airwaybillNumber")
    private String airwaybillNumber;
    @JsonProperty("isCrossBorder")
    private boolean isCrossBorder;
    @JsonProperty("quantity")
    private String quantity;
    @JsonProperty("cod")
    private COD cod;
    @JsonProperty("valueCustoms")
    private ValueCustoms valueCustoms;
    @JsonProperty("sender")
    private Sender sender;
    @JsonProperty("receiver")
    private Receiver receiver;
    @JsonProperty("serviceType")
    private ServiceType serviceType;
    @JsonProperty("deliveryFee")
    private String deliveryFee;
    @JsonProperty("tax")
    private String tax;
    @JsonProperty("grandTotal")
    private String grandTotal;
    @JsonProperty("totalWeight")
    private double totalWeight;
    @JsonProperty("handlingFee")
    private String handlingFee;
    @JsonProperty("deliveryStatus")
    private DeliveryStatus deliveryStatus;
    @JsonProperty("isOrderRefForConnote")
    private boolean isOrderRefForConnote;
    @JsonProperty("isNonPickup")
    private Boolean isNonPickup;
    @JsonProperty("isDropOffDateFollowSLA")
    private boolean isDropOffDateFollowSLA;
    @JsonProperty("isMultiplePickupLocation")
    private Boolean isMultiplePickupLocation;
    @JsonProperty("isServiceTypeDefinedInCSV")
    private boolean isServiceTypeDefinedInCSV;
    @JsonProperty("parcels")
    private List<Parcel> parcels;
    @JsonProperty("reason")
    private Reason reason;

    public Delivery() {
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public String get_Id() {
        return _id;
    }

    public String getRefId() {
        return refId;
    }

    public String getAirwaybillNumber() {
        return airwaybillNumber;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public String getQuantity() {
        return quantity;
    }

    public boolean getCrossBorder() {
        return isCrossBorder;
    }

    public COD getCod() {
        return cod;
    }

    public ValueCustoms getValueCustoms() {
        return valueCustoms;
    }

    public Sender getSender() {
        return sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public String getHandlingFee() {
        return handlingFee;
    }

    public String getTax() {
        return tax;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public boolean getOrderRefForConnote() {
        return isOrderRefForConnote;
    }

    public boolean getNonPickup() {
        return isNonPickup;
    }

    public boolean getDropOffDateFollowSLA() {
        return isDropOffDateFollowSLA;
    }

    public boolean getMultiplePickupLocation(){
        return isMultiplePickupLocation;
    }

    public boolean getServiceTypeDefinedInCSV(){
        return isServiceTypeDefinedInCSV;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public Reason getReason() {
        return reason;
    }

    public Delivery setMerchant(Merchant merchant) {
        this.merchant = merchant;
        return this;
    }

    public Delivery set_Id(String _id) {
        this._id = _id;
        return this;
    }

    public Delivery setRefId(String refId) {
        this.refId = refId;
        return this;
    }

    public Delivery setAirwaybillNumber(String airwaybillNumber) {
        this.airwaybillNumber = airwaybillNumber;
        return this;
    }

    public Delivery setOrderRef(String orderRef) {
        this.orderRef = orderRef;
        return this;
    }

    public Delivery setCrossBorder(boolean isCrossBorder) {
        this.isCrossBorder = isCrossBorder;
        return this;
    }

    public Delivery setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public Delivery setCod(COD cod) {
        this.cod = cod;
        return this;
    }

    public Delivery valueCustoms(ValueCustoms valueCustoms) {
        this.valueCustoms = valueCustoms;
        return this;
    }

    public Delivery setSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    public Delivery setReceiver(Receiver receiver) {
        this.receiver = receiver;
        return this;
    }

    public Delivery setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public Delivery setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
        return this;
    }

    public Delivery setTax(String tax) {
        this.tax = tax;
        return this;
    }

    public Delivery setHandlingFee(String handlingFee) {
        this.handlingFee = handlingFee;
        return this;
    }

    public Delivery setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
        return this;
    }

    public Delivery setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
        return this;
    }

    public Delivery setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        return this;
    }

    public void setOrderRefForConnote(boolean orderRefForConnote) {
        isOrderRefForConnote = orderRefForConnote;
    }

    public Delivery setNonPickup(Boolean isNonPickup){
        this.isNonPickup = isNonPickup;
        return this;
    }

    public Delivery setDropOffDateFollowSLA(boolean isDropOffDateFollowSLA){
        this.isDropOffDateFollowSLA = isDropOffDateFollowSLA;
        return this;
    }

    public Delivery setMultiplePickupLocation(Boolean isMultiplePickupLocation){
        this.isMultiplePickupLocation = isMultiplePickupLocation;
        return this;
    }

    public Delivery setServiceTypeDefinedInCSV(boolean isServiceTypeDefinedInCSV){
        this.isServiceTypeDefinedInCSV = isServiceTypeDefinedInCSV;
        return this;
    }

    public Delivery setParcel(List<Parcel> parcels) {
        this.parcels = parcels;
        return this;
    }

    public Delivery setReason(Reason reason) {
        this.reason = reason;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("_id", _id)
                .append("refId", refId)
                .append("orderRef", orderRef)
                .append("isCrossBorder", isCrossBorder)
                .append("quantity", quantity)
                .append("cod", cod)
                .append("valueCustoms", valueCustoms)
                .append("sender", sender)
                .append("receiver", receiver)
                .append("serviceType", serviceType)
                .append("deliveryFee", deliveryFee)
                .append("tax", tax)
                .append("grandTotal", grandTotal)
                .append("totalWeight", totalWeight)
                .append("handlingFee", handlingFee)
                .append("deliveryStatus", deliveryStatus)
                .append("isOrderRefForConnote", isOrderRefForConnote)
                .append("isNonPickup", isNonPickup)
                .append("isDropOffDateFollowSLA", isDropOffDateFollowSLA)
                .append("isMultiplePickupLocation", isMultiplePickupLocation)
                .append("isServiceTypeDefineInCSV", isServiceTypeDefinedInCSV)
                .append("parcels", parcels)
                .append("reason", reason)
                .toString();
    }

}


