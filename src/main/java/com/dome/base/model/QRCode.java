package com.dome.base.model;

/**
 * Created by akalamichael on 11/13/16.
 */
public class QRCode {
    public long id;
    public long animalId;
    public QRCode(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }
}
