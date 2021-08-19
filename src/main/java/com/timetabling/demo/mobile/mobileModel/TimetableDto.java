package com.timetabling.demo.mobile.mobileModel;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.ClassRoom;
import com.timetabling.demo.model.Module;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class TimetableDto {
    private int timetableId;
    private String startTime;
    private String endTime;
    private Date scheduledDate;
    private List<BatchDto> batches;
    private ModuleDto modules;
    private ClassroomDto classRoom;

    public TimetableDto() {
    }

    public TimetableDto(int timetableId, String startTime, String endTime, Date scheduledDate, List<BatchDto> batches, ModuleDto modules, ClassroomDto classRoom) {
        this.timetableId = timetableId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduledDate = scheduledDate;
        this.batches = batches;
        this.modules = modules;
        this.classRoom = classRoom;
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

    public List<BatchDto> getBatches() {
        return batches;
    }

    public void setBatches(List<BatchDto> batches) {
        this.batches = batches;
    }

    public ModuleDto getModules() {
        return modules;
    }

    public void setModules(ModuleDto modules) {
        this.modules = modules;
    }

    public ClassroomDto getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassroomDto classRoom) {
        this.classRoom = classRoom;
    }
}
