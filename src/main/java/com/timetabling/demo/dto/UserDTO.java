package com.timetabling.demo.dto;

import com.timetabling.demo.model.Batch;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class UserDTO {

    private String email;
    @NotNull(message = "Last name is not completed")
    private String fName;
    @NotNull(message = "Last name is not completed")
    private String lName;
    @Pattern(regexp="(^$|[0-9]{10})",message = "Incorrect Mobile Number")
    private String contactNumber;
    private String userRole;
    private Batch batchId;
    private String password;

    public UserDTO(String email, String fName, String lName, String contactNumber, String userRole, Batch batchId, String password) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.contactNumber = contactNumber;
        this.userRole = userRole;
        this.batchId = batchId;
        this.password = password;
    }

    public UserDTO() {

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
