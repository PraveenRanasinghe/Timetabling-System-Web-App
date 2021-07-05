package com.timetabling.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "class_room")
public class ClassRoom {
    @Id
    @Column(name = "class_roomid")
    private String classRoomID;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "smart_board")
    private String smartBoard;

    @Column(name = "ac")
    private String Ac;

    public ClassRoom(String classRoomID, String capacity, String smartBoard, String ac) {
        this.classRoomID = classRoomID;
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
