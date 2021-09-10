package com.timetabling.demo.testDto;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.User;

import java.util.List;

public class ModuleDTO {
    private String moduleID;
    private String moduleName;
    private User user;
    private List<Batch> batches;

    public ModuleDTO(String moduleID, String moduleName, User user, List<Batch> batches) {
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.user = user;
        this.batches = batches;
    }

    public ModuleDTO(){

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

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }
}
