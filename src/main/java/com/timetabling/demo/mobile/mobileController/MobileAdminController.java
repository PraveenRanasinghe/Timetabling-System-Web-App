package com.timetabling.demo.mobile.mobileController;


import com.timetabling.demo.dto.*;
import com.timetabling.demo.exceptions.BatchIdExistException;
import com.timetabling.demo.exceptions.UserAlreadyExistsException;
import com.timetabling.demo.exceptions.classRoomIdExistException;
import com.timetabling.demo.mobile.mobileModel.BatchDto;
import com.timetabling.demo.mobile.mobileModel.ClassroomDto;
import com.timetabling.demo.mobile.mobileModel.TimetableDto;
import com.timetabling.demo.mobile.mobileModel.UserDto;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.ClassRoom;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/getAllLecturers")
    public ResponseEntity<?> getAllLecturersToList() {
        List<userDTO> allLecturers = userService.getAllLecturersToList();
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
        List<moduleDTO> allModules = moduleService.getAllModulesToList();
        return ResponseEntity.ok(allModules);
    }

    @PostMapping("/addStudents")
    public ResponseEntity<?> StudentRegistration(@RequestBody UserDto dto) throws UserAlreadyExistsException {

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

    @PostMapping("/addLecturers")
    public ResponseEntity<?> LecturerRegistration(@RequestBody UserDto dto) throws UserAlreadyExistsException {

        userDTO userDTO = new userDTO();
        userDTO.setEmail(dto.getEmail());
        userDTO.setfName(dto.getfName());
        userDTO.setlName(dto.getlName());
        userDTO.setUserRole(dto.getUserRole());
        userDTO.setContactNumber(dto.getContactNumber());

        userService.registerUsers(userDTO);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/addClassrooms")
    public ResponseEntity<?> addClassRooms(@RequestBody ClassroomDto dto) throws classRoomIdExistException {

        classRoomDTO classDto = new classRoomDTO();
        classDto.setClassRoomID(dto.getClassRoomID());
        classDto.setCapacity(dto.getCapacity());
        classDto.setAc(dto.getAc());
        classDto.setSmartBoard(dto.getSmartBoard());

        classRoomService.addClassRoom(classDto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/addBatch")
    public ResponseEntity<?> addBatch(@RequestBody BatchDto dto) throws BatchIdExistException {

        batchDTO batchDto = new batchDTO();
        batchDto.setBatchID(dto.getBatchID());
        batchDto.setBatchName(dto.getBatchName());
        batchDto.setStartDate(dto.getStartDate());
        batchDto.setEndDate(dto.getEndDate());

        batchService.createBatch(batchDto);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/scheduleTimetable")
    public ResponseEntity<?> scheduleTimetable(@RequestBody TimetableDto dto) throws Exception {

        timetableDTO timetableDto = new timetableDTO();
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


}
