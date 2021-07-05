package com.timetabling.demo.model;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.Mergeable;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @Column(name = "timetable_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int timetableId;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "scheduled_date")
    private Date scheduledDate;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "module_id")
    private Module module;


    @ManyToOne
    @JoinColumn(name = "class_roomid")
    private ClassRoom classRoom;


    @ManyToMany
    @JoinTable(
            name = "batch_timetable",
            joinColumns = @JoinColumn(name = "timetable_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )

    private List<Batch> batches;


    public Timetable(int timetableId, LocalTime startTime, LocalTime endTime, Date scheduledDate, Module module, ClassRoom classRoom, List<Batch> batches) {
        this.timetableId = timetableId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduledDate = scheduledDate;
        this.module = module;
        this.classRoom = classRoom;
        this.batches = batches;
    }

    public Timetable() {

    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }


    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}

