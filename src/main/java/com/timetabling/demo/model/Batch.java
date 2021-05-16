package com.timetabling.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Batch {
    @Id
    private String batchID;
    private String batchName;
    private Date startDate;
    private Date endDate;

    public Batch(String batchID, String batchName, Date startDate, Date endDate) {
        this.batchID = batchID;
        this.batchName = batchName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Batch() {

    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
