package com.dome.base.model;

import java.util.Date;
public class Reservation{
    private long id;
    private Date startdate;
    private Date enddate;
    private String reserver;
    
    public Reservation(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startdate;
    }

    public void setStartDate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEndDate() {
        return enddate;
    }

    public void setEndDate(Date enddate) {
        this.enddate = enddate;
    }

    public String getReserver() {
        return reserver;
    }

    public void setReserver(String reserver) {
        this.reserver = reserver;
    }
}