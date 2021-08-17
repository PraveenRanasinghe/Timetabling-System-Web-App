package com.timetabling.demo.mobile.mobileModel;

import com.timetabling.demo.model.Timetable;

public class ClassroomDto {
    private String classRoomID;
    private TimetableDto timetable;
    private String capacity;
    private String smartBoard;
    private String Ac;

    public ClassroomDto(String classRoomID, TimetableDto timetable, String capacity, String smartBoard, String ac) {
        this.classRoomID = classRoomID;
        this.timetable = timetable;
        this.capacity = capacity;
        this.smartBoard = smartBoard;
        Ac = ac;
    }

    public String getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(String classRoomID) {
        this.classRoomID = classRoomID;
    }

    public TimetableDto getTimetable() {
        return timetable;
    }

    public void setTimetable(TimetableDto timetable) {
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
