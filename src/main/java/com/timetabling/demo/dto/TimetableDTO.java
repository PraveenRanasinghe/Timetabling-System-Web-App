package com.timetabling.demo.dto;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.ClassRoom;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class TimetableDTO {
    private int timetableId;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private String startTime;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private String endTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date scheduledDate;

    private List<Batch> batches;
    private Module modules;
    private ClassRoom classRoom;

    public TimetableDTO(int timetableId, String startTime, String endTime, Date scheduledDate, List<Batch> batches, Module modules, ClassRoom classRoom) {
        this.timetableId = timetableId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduledDate = scheduledDate;
        this.batches = batches;
        this.modules = modules;
        this.classRoom = classRoom;
    }

    public TimetableDTO() {

    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    public Module getModules() {
        return modules;
    }

    public void setModules(Module modules) {
        this.modules = modules;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
