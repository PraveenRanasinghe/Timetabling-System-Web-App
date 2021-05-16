package com.timetabling.demo.model;

import javax.persistence.*;

@Entity
public class ClassRoom {
    @Id
    private String classRoomID;

    @OneToOne
    @JoinColumn(name = "timetable_id")
    private Timetable timetable;

    private String capacity;
    private String smartBoard;
    private String Ac;

    public ClassRoom(String classRoomID, Timetable timetable, String capacity, String smartBoard, String ac) {
        this.classRoomID = classRoomID;
        this.timetable = timetable;
        this.capacity = capacity;
        this.smartBoard = smartBoard;
        Ac = ac;
    }

    public ClassRoom() {

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
