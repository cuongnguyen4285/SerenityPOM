package com.simplypost.logistic.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TimeWindowApi {

    @JsonProperty("to")
    private int to;
    @JsonProperty("from")
    private int from;

    public int getTo() {
        return to;
    }

    public TimeWindowApi setTo(int to) {
        this.to = to;
        return this;
    }

    public int getFrom() {
        return from;
    }

    public TimeWindowApi setFrom(int from) {
        this.from = from;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(
                this).append("to", to)
                .append("from", from).toString();
    }
}
