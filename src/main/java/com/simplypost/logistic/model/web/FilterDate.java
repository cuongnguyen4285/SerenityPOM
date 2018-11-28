package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonPropertyOrder({
//        "dateType",
//        "toDate",
//        "fromDate"
//})
public class FilterDate {

    @JsonProperty("dateType")
    private FilterDateType dateType;
    @JsonProperty("toDate")
    private String toDate;
    @JsonProperty("fromDate")
    private String fromDate;

    public FilterDate(){
    }

    public FilterDateType getDateType(){
        return dateType;
    }

    public String getToDate(){
        return toDate;
    }

    public String getFromDate(){
        return fromDate;
    }

    public FilterDate setDateType(FilterDateType dateType){
        this.dateType = dateType;
        return this;
    }

    public FilterDate setToDate(String toDate) {
        this.toDate = toDate;
        return this;
    }

    public FilterDate setFromDate(String fromDate){
        this.fromDate = fromDate;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("dateType", dateType.toString())
                .append("toDate", toDate)
                .append("fromDate", fromDate)
                .toString();
    }

}

