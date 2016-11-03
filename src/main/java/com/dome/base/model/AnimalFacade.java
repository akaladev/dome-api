package com.dome.base.model;

public class AnimalFacade{
    private long id;
    private String name;
    private String scientificName;
    private String image;
    private String imageGeo;
    private String description;
    private long specieId;
    private long nationId;
    private long provinceId;
    private long colorId;
    
    public AnimalFacade(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageGeo() {
        return imageGeo;
    }

    public void setImageGeo(String imageGeo) {
        this.imageGeo = imageGeo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSpecieId() {
        return specieId;
    }

    public void setSpecieId(long specieId) {
        this.specieId = specieId;
    }

    public long getNationId() {
        return nationId;
    }

    public void setNationId(long nationId) {
        this.nationId = nationId;
    }

    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }

    public long getColorId() {
        return colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }
}