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

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private TimetableService timetableService;

    @GetMapping("/home")
    public String getLogin(){
        return "Home";
    }

//     @GetMapping("/viewStudentHome")
//     public String getStudentHome(Model m){
//         List<Timetable> allTimetables= timetableService.getAllTimetablesToStudent();
//         m.addAttribute("timetables", allTimetables);
//        return "studentHome";
//    }

//    @GetMapping("/viewLecturerHome")
//    public String getViewLecturerHome(Model m){
//        List<Timetable> allTimetables= timetableService.getAllTimetablesToLec();
//        m.addAttribute("timetables", allTimetables);
//        return "lecturerHome";
//    }



    @GetMapping("/viewAdminHome")
    public String getAdminHome(){return "AdminHome";}



//    @GetMapping("/viewUpdateLecAccount")
//    public String getViewUpdateLecAccount(){return "updateLecAccount";}
//
//    @GetMapping("/viewUpdateStudAccount")
//    public String getViewUpdateStudAccount(){return "updateStudAccount";}


    @GetMapping("/successfulLogin")
    public String successfulLogin(Authentication auth, Model model){
        User user= userService.directUserType(auth.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getUserRole());

        if(user.getUserRole().equals("student")){
            model.addAttribute("studentDetails", user);
            System.out.println(user.getEmail());
            return "redirect:/viewStudentHome";
        }

        if(user.getUserRole().equals("lecturer")){
            model.addAttribute("LecDetails", user);
            return "redirect:/viewLecturerHome";
        }

        if(user.getUserRole().equals("admin")){
//            userService.updateUserInfo(auth.getName());
            model.addAttribute("adminDetails", user);
            System.out.println(user.getEmail());
            System.out.println(user.getUserRole());
            return "redirect:/viewAdminHome";
        }

        return "Admin";
    }

}
