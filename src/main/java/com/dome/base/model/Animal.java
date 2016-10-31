package com.dome.base.model;

public class Animal{
    private long id;
    private String name;
    private String scientificName;
    private String image;
    private String imageGeo;
    private String description;
    private Specie specie;
    private NationalStatus nationalStatus;
    private ProvincialStatus provincialStatus;
    
    public Animal(){
        
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

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public NationalStatus getNationalStatus() {
        return nationalStatus;
    }

    public void setNationalStatus(NationalStatus nationalStatus) {
        this.nationalStatus = nationalStatus;
    }

    public ProvincialStatus getProvicialStatus() {
        return provincialStatus;
    }

    public void setProvicialStatus(ProvincialStatus provincialStatus) {
        this.provincialStatus = provincialStatus;
    }
}