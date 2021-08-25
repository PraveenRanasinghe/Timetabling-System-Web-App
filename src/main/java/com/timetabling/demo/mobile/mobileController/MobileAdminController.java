package com.timetabling.demo.mobile.mobileController;


import com.timetabling.demo.dto.*;
import com.timetabling.demo.exceptions.BatchIdExistException;
import com.timetabling.demo.exceptions.UserAlreadyExistsException;
import com.timetabling.demo.exceptions.ClassRoomIdExistException;
import com.timetabling.demo.mobile.mobileModel.BatchDto;
import com.timetabling.demo.mobile.mobileModel.ClassroomDto;
import com.timetabling.demo.mobile.mobileModel.TimetableDto;
import com.timetabling.demo.mobile.mobileModel.UserDto;
import com.timetabling.demo.model.*;
import com.timetabling.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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



    @GetMapping(path = "/getAllLecturers")
    public ResponseEntity<?> getAllLecturersToList() {
        List<UserDTO> allLecturers = userService.getAllLecturersToList();
        return ResponseEntity.ok(allLecturers);
    }

    @GetMapping(path = "/getAllTimetablesForAdmin")
    public ResponseEntity<?> viewScheduledClasses() {
        List<Timetable> allTimetables = timetableService.getAllTimetables();
        return ResponseEntity.ok(allTimetables);
    }

    @GetMapping(path = "/getAllClassesToList")
    public ResponseEntity<?> getAllClassesToList(){
        List<ClassRoomDTO> allClassRooms = classRoomService.getAllClassRoomsToList();
        return ResponseEntity.ok(allClassRooms);
    }

    @GetMapping(path = "/viewAllStudents")
    public ResponseEntity<?> viewAllStudents() {
        List<UserDTO> allUsers = userService.getAllStudents();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/getAdminAccount/")
    public ResponseEntity<?> getMyAccount(Authentication auth) {
        User u = userService.getUserByID(auth.getName());
        return ResponseEntity.ok(u);
    }

    @GetMapping(path = "/viewAllLecturers")
    public ResponseEntity<?> viewAllLecturers() {
        List<UserDTO> allLecturers = userService.getAllLecturers();
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
        List<ModuleDTO> allModules = moduleService.getAllModulesToList();
        return ResponseEntity.ok(allModules);
    }

    @PostMapping("/addStudents")
    public ResponseEntity<?> StudentRegistration(@RequestBody UserDto dto) throws UserAlreadyExistsException {

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(dto.getEmail());
        userDTO.setfName(dto.getfName());
        userDTO.setlName(dto.getlName());
        userDTO.setUserRole(dto.getUserRole());
        userDTO.setBatchId(batchService.getBatchById(dto.getBatchId()));
        userDTO.setContactNumber(dto.getContactNumber());

        userService.registerUsers(userDTO);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/addLecturers")
    public ResponseEntity<?> LecturerRegistration(@RequestBody UserDto dto) throws UserAlreadyExistsException {

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(dto.getEmail());
        userDTO.setfName(dto.getfName());
        userDTO.setlName(dto.getlName());
        userDTO.setUserRole(dto.getUserRole());
        userDTO.setContactNumber(dto.getContactNumber());

        userService.registerUsers(userDTO);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/addClassrooms")
    public ResponseEntity<?> addClassRooms(@RequestBody ClassroomDto dto) throws ClassRoomIdExistException {

        ClassRoomDTO classDto = new ClassRoomDTO();
        classDto.setClassRoomID(dto.getClassRoomID());
        classDto.setCapacity(dto.getCapacity());
        classDto.setAc(dto.getAc());
        classDto.setSmartBoard(dto.getSmartBoard());

        classRoomService.addClassRoom(classDto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/addBatch")
    public ResponseEntity<?> addBatch(@RequestBody BatchDto dto) throws BatchIdExistException {

        BatchDTO batchDto = new BatchDTO();
        batchDto.setBatchID(dto.getBatchID());
        batchDto.setBatchName(dto.getBatchName());
        batchDto.setStartDate(dto.getStartDate());
        batchDto.setEndDate(dto.getEndDate());

        batchService.createBatch(batchDto);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/scheduleTimetable")
    public ResponseEntity<?> scheduleTimetable(@RequestBody TimetableDto dto) throws Exception {

        TimetableDTO timetableDto = new TimetableDTO();
        timetableDto.setTimetableId(dto.getTimetableId());
        timetableDto.setStartTime(dto.getStartTime());
        timetableDto.setEndTime(dto.getEndTime());
        //Have to take the Batch List
        timetableDto.setScheduledDate(dto.getScheduledDate());
        timetableDto.setClassRoom(classRoomService.getClassRoomById(dto.getClassRoom().toString()));
        timetableDto.setModules(moduleService.getModuleById(dto.getModules().toString()));

        timetableService.createTimetable(timetableDto);

      return ResponseEntity.ok(dto);
    }

    @PostMapping("/UpdateAccount")
    public ResponseEntity<?> updateAdminAccount(User user) {
        userService.updateUserInfo(user);
        return ResponseEntity.ok(user);
    }


}
