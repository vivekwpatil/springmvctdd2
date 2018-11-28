package com.java.engineering.springmvctdd2.model;

public class CfInfo {

    private String description;
    private String api_version;

    public String getApi_version() {
        return api_version;
    }

    public String getDescription() {
        return description;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
