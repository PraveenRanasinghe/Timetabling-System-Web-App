package com.timetabling.demo.mobile.mobileController;

import com.timetabling.demo.ReqResp.JwtRequest;
import com.timetabling.demo.ReqResp.JwtResponse;
import com.timetabling.demo.mobile.mobileModel.TimetableDto;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.model.User;
import com.timetabling.demo.security.JwtTokenUtil;
import com.timetabling.demo.service.TimetableService;
import com.timetabling.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MobileAuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private TimetableService timetableService;


    @RequestMapping(value = "/mobileAuthentication", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        User user = userDetailsService.getUserByID(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token,user.getUserRole(), user.getEmail()));

    }


    @GetMapping("/todayLecturersForStudent")
    public ResponseEntity<?> getTodayTimetableToStudent(Model m, Authentication auth){
        long date= System.currentTimeMillis();
        java.sql.Date currentDate= new java.sql.Date(date);
        List<Timetable> timetables= timetableService.getTodaysTimetableToStudent(userDetailsService.getUserByID(auth.getName()).getBatch(),currentDate);
        return ResponseEntity.ok(timetables);
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
