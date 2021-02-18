package com.example.londonlandmarks;

import java.io.Serializable;

public class Landmark implements Serializable {

    private String name;
    private String shortDescription;
    private String longDescription;
    private String image;
    private String website;
    private String location;

    //Constructor
    public Landmark(String name, String shortDescription, String longDescription, String image, String website, String location) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image=image;
        this.website=website;
        this.location=location;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
