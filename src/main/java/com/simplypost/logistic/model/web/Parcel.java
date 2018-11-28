package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by scorpion on 26/6/17.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "declaredUnit",
//        "declaredWeight",
//        "declaredLength",
//        "declaredWidth",
//        "declaredHeight",
//        "description"
//})
public class Parcel {

    @JsonProperty("declaredUnit")
    private String declaredUnit;
    @JsonProperty("declaredWeight")
    private String declaredWeight;
    @JsonProperty("description")
    private String description;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("volumetricWeight")
    private String volumetricWeight;
    @JsonProperty("dimension")
    private String dimension;
    @JsonProperty("declaredLength")
    private String declaredLength;
    @JsonProperty("declaredWidth")
    private String declaredWidth;
    @JsonProperty("declaredHeight")
    private String declaredHeight;

    public Parcel() {
    }

    public String getDeclaredUnit() {
        return declaredUnit;
    }

    public String getVolume() {
        return volume;
    }

    public String getDimension() {
        return dimension;
    }

    public String getVolumetricWeight() {
        return volumetricWeight;
    }

    public String getDeclaredWeight() {
        return declaredWeight;
    }

    public String getDescription() {
        return description;
    }

    public String getDeclaredLength() {
        return declaredLength;
    }

    public String getDeclaredWidth() {
        return declaredWidth;
    }

    public String getDeclaredHeight() {
        return declaredHeight;
    }

    public Parcel setDeclaredUnit(String declaredUnit) {
        this.declaredUnit = declaredUnit;
        return this;
    }

    public Parcel setDeclaredWeight(String declaredWeight) {
        this.declaredWeight = declaredWeight;
        return this;
    }

    public Parcel setVolumetricWeight(String volumetricWeight) {
        this.volumetricWeight = volumetricWeight;
        return this;
    }

    public Parcel setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public Parcel setDimension(String dimension) {
        this.dimension = dimension;
        return this;
    }

    public Parcel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Parcel setDeclaredLength(String declaredLength) {
        this.declaredLength = declaredLength;
        return this;
    }

    public Parcel setDeclaredWidth(String declaredWidth) {
        this.declaredWidth = declaredWidth;
        return this;
    }

    public Parcel setDeclaredHeight(String decalredHeight) {
        this.declaredHeight = decalredHeight;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("declaredWeight", declaredWeight)
                .append("declaredUnit", declaredUnit)
                .append("declaredLength", declaredLength)
                .append("declaredWidth", declaredWidth)
                .append("declaredHeight", declaredHeight)
                .append("description", description)
                .toString();
    }

}
