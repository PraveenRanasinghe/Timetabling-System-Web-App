package com.timetabling.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "module")
public class Module {
    @Id
    @Column(name = "module_id")
    private String moduleID;
    @Column(name = "module_name")
    private String moduleName;

    @ManyToOne
    @JoinColumn(name = "email")
    private User user;


    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "batch_module",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )

    private List<Batch> batches;


    public Module(String moduleID, String moduleName, User user, List<Batch> batches) {
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.user = user;
        this.batches = batches;
    }

    public Module() {

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
