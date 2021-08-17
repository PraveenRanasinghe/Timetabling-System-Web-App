package com.timetabling.demo.mobile.mobileModel;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.User;

import java.util.List;

public class ModuleDto {
    private String moduleID;
    private String moduleName;
    private UserDto user;
    private List<BatchDto> batches;

    public ModuleDto(String moduleID, String moduleName, UserDto user, List<BatchDto> batches) {
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.user = user;
        this.batches = batches;
    }

    public ModuleDto() {

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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<BatchDto> getBatches() {
        return batches;
    }

    public void setBatches(List<BatchDto> batches) {
        this.batches = batches;
    }
}
