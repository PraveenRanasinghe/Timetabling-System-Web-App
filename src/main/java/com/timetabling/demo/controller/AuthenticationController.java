package com.timetabling.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/home")
    public String getLogin(){
        return "Home";
    }

    @GetMapping("/viewTimeTable")
    public String getTimeTable(){
        return "studentHome";
    }

    @GetMapping("/viewReScheduling")
    public String getContactAdmin(){
        return "lecturerReScheduling";
    }

    @GetMapping("/viewAdminHome")
    public String getAdminHome(){return "AdminHome";}


    @GetMapping("/viewLecturerHome")
    public String getViewLecturerHome(){return "lecturerHome";}

    @GetMapping("/viewUpdateLecAccount")
    public String getViewUpdateLecAccount(){return "updateLecAccount";}

    @GetMapping("/viewUpdateStudAccount")
    public String getViewUpdateStudAccount(){return "updateStudAccount";}

//    @GetMapping("/viewAdminReScheduling")
//    public String getViewAdminRescheduling(){return "adminReScheduling";}


    @GetMapping("/viewLecCancelClasses")
    public String getViewLecCancelClasses(){return "lecturerCancelClasses";}

//
//    @GetMapping("/viewUpdateModules")
//    public String getViewUpdateModules(){return "updateModules";}

}
