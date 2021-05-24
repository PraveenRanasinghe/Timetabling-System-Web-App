package com.timetabling.demo.controller;


import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.model.User;
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
    private final UserService userService;

    public userController(TimetableService timetableService, UserService userService) {
        this.timetableService = timetableService;
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


    @GetMapping("/viewLecturerHome")
    public String getLecTimetables(Model m, Authentication auth) {
//        System.out.println(auth.getName());
        List<Timetable> allTimetables = timetableService.getLecTimetables(auth.getName());
        m.addAttribute("timetables", allTimetables);
        return "lecturerHome";
    }


    @GetMapping(path = "/viewStudentHome")
    public String LecturerViewTimetable(Model m, Authentication auth) {

        List<Timetable> allTimetables = timetableService.getStudentTimetables(userService.getUserByID(auth.getName()).getBatch());
        m.addAttribute("timetables", allTimetables);
        return "lecturerHome";
    }

}


//    @GetMapping(path = "/viewStudentHome")
//    public String studentViewTimetable(Model m){
//
//        List<Timetable> allTimetables= timetableService.getAllTimetablesToStudent();
//        m.addAttribute("timetables", allTimetables);
//        return "studentHome";
//    }
//
//


//
//    @GetMapping("/viewStudentHome")
//    public String getStudentTimetable(Model m, Authentication auth){
//        List<Timetable> allTimetables= timetableService.getStudentTimetables(auth.getName());
//        m.addAttribute("timetables",allTimetables);
//        return "studentHome";
//    }


//    public String updateUserAccount(Model model, Authentication authentication){
//        model.addAttribute("loggedInUser",userService.updateUserInfo());
//    }
//
//    @GetMapping(path = "/viewStudentHome")
//    public String viewScheduledClasses(Model m){
//        List<Timetable> allTimetables= timetableService.getAllTimetablesToStudent();
//        m.addAttribute("timetables", allTimetables);
//        return "studentHome";
//    }
