package com.timetabling.demo.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private String email;
    private String fName;
    private String lName;
    private String contactNumber;
    private String userRole;

    @ManyToOne
    @JoinColumn(name = "batch_Id")
    private Batch batch;

    private String password;


    public User(String email, String fName, String lName, String contactNumber, String userRole, Batch batch, String password) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.contactNumber = contactNumber;
        this.userRole = userRole;
        this.batch = batch;
        this.password = password;
    }

    public User() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}
