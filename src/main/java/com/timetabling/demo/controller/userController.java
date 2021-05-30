package com.timetabling.demo.controller;


import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.model.User;
import com.timetabling.demo.service.ModuleService;
import com.timetabling.demo.service.TimetableService;
import com.timetabling.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class userController {

    @Autowired
    private final TimetableService timetableService;

    @Autowired
    private final ModuleService moduleService;

    @Autowired
    private final UserService userService;

    public userController(TimetableService timetableService, ModuleService moduleService, UserService userService) {
        this.timetableService = timetableService;
        this.moduleService = moduleService;
        this.userService = userService;
    }

    @GetMapping("/getStudent/")
    public String getStudent(Model m, Authentication auth) {
        User u = userService.getUserByID(auth.getName());
        m.addAttribute("updateStudent", u);
        m.addAttribute("findUser", u);
        return "updateStudAccount";
    }

    @PostMapping("/adminUpdateStudent")
    public String updateStudent(@ModelAttribute("updateStudent") User user, Model a) {
        try {
            userService.updateUserInfo(user);
            a.addAttribute("success", "User has been updated successfully!");

        } catch (Exception e) {
            a.addAttribute("error", "Cannot update the user at this time.Please try again!");
        }

        return "updateStudAccount";
    }

    @GetMapping("/getLecturer/")
    public String getLecturer(Model m, Authentication auth) {
        User u = userService.getUserByID(auth.getName());
        m.addAttribute("updateLec", u);
        m.addAttribute("findUser", u);
        return "updateLecAccount";
    }


    @PostMapping("/adminUpdateLecturer")
    public String updateLecturer(@ModelAttribute("updateLec") User user, Model a) {
        try {
            userService.updateUserInfo(user);
            a.addAttribute("success", "User has been updated successfully!");

        } catch (Exception e) {
            a.addAttribute("error", "Cannot update the user at this time.Please try again!");
        }

        return "updateLecAccount";
    }

    @GetMapping("/getAdmin/")
    public String getAdmin(Model m, Authentication auth) {
        User u = userService.getUserByID(auth.getName());
        m.addAttribute("updateAdmin", u);
        m.addAttribute("findUser", u);
        return "updateAdminAccount";
    }

    @PostMapping("/adminUpdateAdmin")
    public String updateAdmin(@ModelAttribute("updateAdmin") User user, Model a) {
        try {
            userService.updateUserInfo(user);
            a.addAttribute("success", "User has been updated successfully!");

        } catch (Exception e) {
            a.addAttribute("error", "Cannot update the user at this time.Please try again!");
        }

        return "updateAdminAccount";
    }


    @GetMapping("/allTimetablesToLec")
    public String getLecTimetables(Model m, Authentication auth) {
        List<Timetable> allTimetables = timetableService.getLecTimetables(auth.getName());
        m.addAttribute("timetables", allTimetables);
        return "AllTimetablesToLec";
    }


    @GetMapping(path = "/allTimetables")
    public String studentTimetable(Model m, Authentication auth) {

        List<Timetable> allTimetables = timetableService.getStudentTimetables(userService.getUserByID(auth.getName()).getBatch());
        m.addAttribute("timetables", allTimetables);
        return "AllTimetablesToStud";
    }


    @GetMapping("/learningModules")
    public String getBatchModules(Model m, Authentication auth){
        List<Module> allModules = moduleService.getModulesInBatch(userService.getUserByID(auth.getName()).getBatch());
        m.addAttribute("modules",allModules);
        return "myModules";
    }

    @GetMapping("/teachingModules")
    public String getLecModules(Model m,Authentication auth){
        List<Module> allModules=moduleService.getLecturerModules(userService.getUserByID(auth.getName()).getEmail());
        m.addAttribute("modules", allModules);
        return "myBatches";
    }

    @GetMapping("/viewStudentHome")
    public String getTodayTimetableToStudent(Model m, Authentication auth){
        long date= System.currentTimeMillis();
        java.sql.Date currentDate= new java.sql.Date(date);
        List<Timetable> timetables= timetableService.getTodaysTimetableToStudent(userService.getUserByID(auth.getName()).getBatch(),currentDate);
        m.addAttribute("timetables",timetables);
        return "studentHome";
    }

    @GetMapping("/viewLecturerHome")
    public String getTodaysTimetableToLec(Model m,Authentication auth){
        long date= System.currentTimeMillis();
        java.sql.Date currentDate= new java.sql.Date(date);

        List<Timetable> timetableList= timetableService.getTodaysTimetableToLec(userService.getUserByID(auth.getName()).getEmail(),currentDate);
        m.addAttribute("timetables",timetableList);
        return "lecturerHome";

    }


}


