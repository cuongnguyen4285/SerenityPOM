package com.simplypost.logistic.model.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "merchant_code",
        "merchant_name",
        "reference_number",
        "service_code",
        "pickup_details",
        "consignee_details",
        "item_details",
        "cod",
        "customs_declaration"
})
public class DeliveryApi {

    @JsonProperty("merchant_code")
    private String merchant_code;
    @JsonProperty("original_order_number")
    private String original_order_number;
    @JsonProperty("merchant_name")
    private String merchant_name;
    @JsonProperty("reference_number")
    private String reference_number;
    @JsonProperty("airwaybill_number")
    private String airwaybill_number;
    @JsonProperty("service_code")
    private String service_code;
    @JsonProperty("pickup_details")
    private PickupDetailsApi pickup_details;
    @JsonProperty("consignee_details")
    private ConsigneeDetailsApi consignee_details;
    @JsonProperty("item_details")
    private List<ItemDetailApi> item_details;
    @JsonProperty("cod")
    private CODApi cod;
    @JsonProperty("customs_declaration")
    private ValueCustomsApi customs_declaration;

    public String getOriginalOrderNumber() {
        return original_order_number;
    }

    public DeliveryApi setOriginal_order_number(String original_order_number) {
        this.original_order_number = original_order_number;
        return this;
    }

    public String getMerchantCode() {
        return merchant_code;
    }

    public DeliveryApi setMerchantCode(String merchant_code) {
        this.merchant_code = merchant_code;
        return this;
    }

    public String getMerchantName() {
        return merchant_name;
    }

    public DeliveryApi setMerchantName(String merchant_name) {
        this.merchant_name = merchant_name;
        return this;
    }

    public String getReferenceNumber() {
        return reference_number;
    }

    public DeliveryApi setReferenceNumber(String reference_number) {
        this.reference_number = reference_number;
        return this;
    }

    public String getAirwaybillNumber() {
        return airwaybill_number;
    }

    public DeliveryApi setAirwaybillNumber(String airwaybill_number) {
        this.airwaybill_number = airwaybill_number;
        return this;
    }

    public String getServiceCode() {
        return service_code;
    }

    public DeliveryApi setServiceCode(String serviceCode) {
        this.service_code = serviceCode;
        return this;
    }

    public PickupDetailsApi getPickupDetails() {
        return pickup_details;
    }

    public DeliveryApi setPickupDetails(PickupDetailsApi pickupDetails) {
        this.pickup_details = pickupDetails;
        return this;
    }

    public ConsigneeDetailsApi getConsigneeDetails() {
        return consignee_details;
    }

    public DeliveryApi setConsigneeDetails(ConsigneeDetailsApi consignee_details) {
        this.consignee_details = consignee_details;
        return this;
    }

    public List<ItemDetailApi> getItemDetails() {
        return item_details;
    }

    public DeliveryApi setItemDetails(List<ItemDetailApi> itemDetails) {
        this.item_details = itemDetails;
        return this;
    }

    public CODApi getCod() {
        return cod;
    }

    public DeliveryApi setCod(CODApi cod) {
        this.cod = cod;
        return this;
    }

    public ValueCustomsApi getValueCustoms(){
        return customs_declaration;
    }

    public DeliveryApi setValueCustoms(ValueCustomsApi customs_declaration){
        this.customs_declaration = customs_declaration;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("merchant_code", merchant_code)
                .append("reference_number", reference_number)
                .append("service_code", service_code)
                .append("pickup_details", pickup_details)
                .append("consignee_details", consignee_details)
                .append("item_details", item_details)
                .append("customs_declaration", customs_declaration)
                .append("cod", cod).toString();
    }

}