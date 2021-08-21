package com.timetabling.demo.mobile.mobileController;


import com.timetabling.demo.dto.userDTO;
import com.timetabling.demo.exceptions.UserAlreadyExistsException;
import com.timetabling.demo.mobile.mobileModel.UserDto;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.ClassRoom;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class MobileAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private ModuleService moduleService;


    @GetMapping(path = "/viewAllStudents")
    public ResponseEntity<?> viewAllStudents() {
        List<userDTO> allUsers = userService.getAllStudents();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping(path = "/viewAllLecturers")
    public ResponseEntity<?> viewAllLecturers() {
        List<userDTO> allLecturers = userService.getAllLecturers();
        return ResponseEntity.ok(allLecturers);
    }

    @GetMapping(path = "/viewAllBatches")
    public ResponseEntity<?> viewAllBatches() {
        List<Batch> allBatches = batchService.getAllBatches();
        return ResponseEntity.ok(allBatches);
    }

    @GetMapping(path = "/viewAllScheduledClasses")
    public ResponseEntity<?> viewAllScheduledClasses() {
        List<Timetable> allTimetables = timetableService.getAllTimetables();
        return ResponseEntity.ok(allTimetables);
    }

    @GetMapping("/viewAllClassRooms")
    public ResponseEntity<?> viewAllClasses() {
        List<ClassRoom> allClassRooms = classRoomService.getAllClassRooms();
        return ResponseEntity.ok(allClassRooms);
    }

    @GetMapping(path = "/viewAllModules")
    public ResponseEntity<?> viewAllModules() {
        List<Module> allModules = moduleService.getAllModules();
        return ResponseEntity.ok(allModules);
    }

    @PostMapping("/addStudents")
    public ResponseEntity<?> StudentRegistration(@RequestBody UserDto dto) throws UserAlreadyExistsException {
        System.out.println(dto);
        userDTO userDTO = new userDTO();
        userDTO.setEmail(dto.getEmail());
        userDTO.setfName(dto.getfName());
        userDTO.setlName(dto.getlName());
        userDTO.setUserRole(dto.getUserRole());
        userDTO.setBatchId(batchService.getBatchById(dto.getBatchId()));
        userDTO.setContactNumber(dto.getContactNumber());

        userService.registerUsers(userDTO);
        return ResponseEntity.ok(dto);
    }

}
