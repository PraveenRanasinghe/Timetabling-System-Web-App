package com.timetabling.demo.WebController;

import com.timetabling.demo.model.User;
import com.timetabling.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String getLogin(){
        return "Home";
    }

    @GetMapping("/viewAdminHome")
    public String getAdminHome(){
        return "AdminHome";
    }

    @GetMapping("/successfulLogin")
    public String successfulLogin(Authentication auth, Model model, RedirectAttributes redirectAttributes){

        try{
            User user= userService.directUserType(auth.getName());
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
                model.addAttribute("adminDetails", user);
                return "redirect:/viewAdminHome";
            }
        }
        catch (Exception ex){
             redirectAttributes.addFlashAttribute("error", "Invalid Credentials. Please check your Email and Password again!");
        }

        return "Home";
    }

    @GetMapping("/error")
    public String InvalidLogin(RedirectAttributes attributes){
        attributes.addFlashAttribute("error", "Invalid Credentials !");
        return "Home";
    }


}
