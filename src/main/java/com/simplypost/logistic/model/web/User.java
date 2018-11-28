package com.simplypost.logistic.model.web;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scorpion on 6/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "email",
        "firstName",
        "lastName",
        "fullName",
        "password",
        "createdAt",
        "contractType",
        "lastLogin",
        "isLocked",
        "isApproved"
})
public class User {

    @JsonProperty("id")
    private String id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("contractType")
    private String contractType;
    @JsonProperty("lastLogin")
    private String lastLogin;
    @JsonProperty("isLocked")
    private Boolean isLocked;
    @JsonProperty("isApproved")
    private Boolean isApproved;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public User(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getContractType() {
        return contractType;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setFullName(String fullName){
        this.fullName = fullName;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User setContractType(String contractType) {
        this.contractType = contractType;
        return this;
    }

    public User setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public User setLocked(Boolean isLocked) {
        this.isLocked = isLocked;
        return this;
    }

    public User setApproved(Boolean isApproved) {
        this.isApproved = isApproved;
        return this;
    }

    public User additionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("id", id)
                .append("email", email)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("password", password)
                .append("createdAt", createdAt)
                .append("contractType", contractType)
                .append("lastLogin", lastLogin)
                .append("isLocked", isLocked)
                .append("isApproved", isApproved)
                .toString();
    }

}



