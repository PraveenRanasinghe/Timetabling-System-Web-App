package com.timetabling.demo.model;

import javax.persistence.*;
import java.util.List;

/**
 * This class will be acting as an entity for the Module table.
 *
 * @author Praveen Ranasinghe
 * @version 1.0
 */
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

    @OneToMany(mappedBy = "module")
    private List<Timetable> lectureList;


    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "batch_module",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )
    private List<Batch> batches;

    public Module() {

    }

    public Module(String moduleID, String moduleName, User user, List<Batch> batches) {
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.user = user;
        this.batches = batches;
    }


    public List<Timetable> getLectureList() {
        return lectureList;
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
