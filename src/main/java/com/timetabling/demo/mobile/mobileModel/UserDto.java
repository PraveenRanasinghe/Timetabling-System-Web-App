package com.timetabling.demo.mobile.mobileModel;

import com.timetabling.demo.model.Batch;

import javax.validation.constraints.NotEmpty;

public class UserDto {
    private String email;
    private String fName;
    private String lName;
    private String contactNumber;
    private String userRole;
    private BatchDto batchId;
    private String password;

    public UserDto(String email, String fName, String lName, String contactNumber, String userRole, BatchDto batchId, String password) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.contactNumber = contactNumber;
        this.userRole = userRole;
        this.batchId = batchId;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public BatchDto getBatchId() {
        return batchId;
    }

    public void setBatchId(BatchDto batchId) {
        this.batchId = batchId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
