package com.timetabling.demo.dto;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.ClassRoom;
import com.timetabling.demo.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class timetableDTO {
    private int timetableId;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private String startTime;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private String endTime;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scheduledDate;

    private String moduleName;
    private Batch batch;
    private User user;
    private ClassRoom classRoom;


    public timetableDTO(int timetableId, String startTime, String endTime, Date scheduledDate, String moduleName, Batch batch, User user, ClassRoom classRoom) {
        this.timetableId = timetableId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduledDate = scheduledDate;
        this.moduleName = moduleName;
        this.batch = batch;
        this.user = user;
        this.classRoom = classRoom;
    }

    public timetableDTO(){

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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
