package com.timetabling.demo.dto;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.User;

public class moduleDTO {
    private String moduleID;
    private String moduleName;
    private User user;
    private Batch batch;

    public moduleDTO(String moduleID, String moduleName, User user, Batch batch) {
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.user = user;
        this.batch = batch;
    }

    public moduleDTO(){

    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}
