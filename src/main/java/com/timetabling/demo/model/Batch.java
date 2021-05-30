package com.timetabling.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Batch {
    @Id
    @Column(name = "batch_id")
    private String batchID;
    @Column(name = "batch_name")
    private String batchName;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @ManyToMany
    @JoinTable(
            name = "batch_module",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Module> modules;

    @ManyToMany
    @JoinTable(
            name = "batch_timetable",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "timetable_id")
    )
    private List<Timetable> timetables;



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
