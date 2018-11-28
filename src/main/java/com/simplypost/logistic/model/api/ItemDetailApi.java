package com.simplypost.logistic.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "length",
        "width",
        "height",
        "weight",
        "weight_unit",
        "quantity",
        "description"
})
public class ItemDetailApi {

    @JsonProperty("length")
    private String length;
    @JsonProperty("width")
    private String width;
    @JsonProperty("height")
    private String height;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("weight_unit")
    private String weight_unit;
    @JsonProperty("quantity")
    private String quantity;
    @JsonProperty("description")
    private String description;

    public String getLength() {
        return length;
    }

    public ItemDetailApi setLength(String length) {
        this.length = length;
        return this;
    }

    public String getWidth() {
        return width;
    }

    public ItemDetailApi setWidth(String width) {
        this.width = width;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public ItemDetailApi setHeight(String height) {
        this.height = height;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public ItemDetailApi setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public ItemDetailApi setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public String getWeightUnit() {
        return weight_unit;
    }

    public ItemDetailApi setWeightUnit(String weight_unit) {
        this.weight_unit = weight_unit;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public ItemDetailApi setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemDetailApi setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("length", length).append("width", width).append("height", height).append("weight", weight).append("weightUnit", weight_unit).append("description", description).toString();
    }

}
