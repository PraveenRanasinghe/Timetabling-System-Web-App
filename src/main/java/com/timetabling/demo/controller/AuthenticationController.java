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

    @GetMapping("/viewAdminHome")
    public String getAdminHome(){
        return "AdminHome";
    }


    @GetMapping("/successfulLogin")
    public String successfulLogin(Authentication auth, Model model){
        User user= userService.directUserType(auth.getName());
//        System.out.println(user.getEmail());
        System.out.println(user.getUserRole());

        if(user.getUserRole().equals("student")){
            model.addAttribute("studentDetails", user);
            return "redirect:/viewStudentHome";
        }

        if(user.getUserRole().equals("lecturer")){
            model.addAttribute("LecDetails", user);
            return "redirect:/viewLecturerHome";
        }

        if(user.getUserRole().equals("admin")){
//            userService.updateUserInfo(auth.getName());
            model.addAttribute("adminDetails", user);
            return "redirect:/viewAdminHome";
        }

        return "Admin";
    }

}
