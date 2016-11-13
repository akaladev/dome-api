package com.dome.base.model;

/**
 * Created by akalamichael on 11/13/16.
 */
public class QRCode {
    public long id;
    public String animalId;
    public QRCode(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }
}
