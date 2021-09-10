package com.timetabling.demo.testDto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BatchDTO {
    private String batchID;
    private String batchName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public BatchDTO(String batchID, String batchName, Date startDate, Date endDate) {
        this.batchID = batchID;
        this.batchName = batchName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BatchDTO(){

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
