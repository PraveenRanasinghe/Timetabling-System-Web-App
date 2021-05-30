package com.timetabling.demo.dto;

import com.timetabling.demo.model.Batch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class userDTO {

    @Email(message = "Last name is not completed")
    private String email;
    @NotEmpty
    private String fName;
    @NotEmpty(message = "Last name is not completed")
    private String lName;
    private String contactNumber;
    private String userRole;
    private Batch batchId;
    private String password;

    public userDTO(String email, String fName, String lName, String contactNumber, String userRole, Batch batchId, String password) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.contactNumber = contactNumber;
        this.userRole = userRole;
        this.batchId = batchId;
        this.password = password;
    }

    public userDTO() {

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

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
