package com.dome.base.model;

/**
 * Created by akalamichael on 11/13/16.
 */
public class Theme {
    private long id;
    private String color;
    private String Images;

    public Theme(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }
}
