package com.dome.base.model;

import java.util.Date;

/**
 * Created by akalamichael on 11/13/16.
 */
public class ReserveModel {
    private long id;
    private String startdate;
    private String enddate;
    private String reserver;

    public ReserveModel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getReserver() {
        return reserver;
    }

    public void setReserver(String reserver) {
        this.reserver = reserver;
    }
}
