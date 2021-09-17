package com.timetabling.demo.dto;

import com.timetabling.demo.model.Timetable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;


public class ClassRoomDTO {
    private String classRoomID;
    private Timetable timetable;
    @Max(value = 100, message = "Capacity should not be more than 100")
    private String capacity;
    private String smartBoard;
    private String Ac;

    public ClassRoomDTO(String classRoomID, Timetable timetable, String capacity, String smartBoard, String ac) {
        this.classRoomID = classRoomID;
        this.timetable = timetable;
        this.capacity = capacity;
        this.smartBoard = smartBoard;
        Ac = ac;
    }

    public ClassRoomDTO(){

    }

    public String getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(String classRoomID) {
        this.classRoomID = classRoomID;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getSmartBoard() {
        return smartBoard;
    }

    public void setSmartBoard(String smartBoard) {
        this.smartBoard = smartBoard;
    }

    public String getAc() {
        return Ac;
    }

    public void setAc(String ac) {
        Ac = ac;
    }
}
