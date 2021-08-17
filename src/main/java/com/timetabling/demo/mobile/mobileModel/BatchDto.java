package com.timetabling.demo.mobile.mobileModel;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BatchDto {
    private String batchID;
    private String batchName;
    private Date startDate;
    private Date endDate;

    public BatchDto(String batchID, String batchName, Date startDate, Date endDate) {
        this.batchID = batchID;
        this.batchName = batchName;
        this.startDate = startDate;
        this.endDate = endDate;
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
