package com.timetabling.demo.mobile.mobileController;


import com.timetabling.demo.dto.*;
import com.timetabling.demo.exceptions.BatchIdExistException;
import com.timetabling.demo.exceptions.ModuleIdExistException;
import com.timetabling.demo.exceptions.UserAlreadyExistsException;
import com.timetabling.demo.exceptions.ClassRoomIdExistException;
import com.timetabling.demo.mobile.mobileModel.*;
import com.timetabling.demo.model.*;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
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

    @GetMapping("/getBatchesToList")
    public ResponseEntity<?> RegisterUsers() {
        List<BatchDTO> allBatches = batchService.getAllBatchesToList();
        return ResponseEntity.ok(allBatches);
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
    public ResponseEntity<?> viewAllScheduledClasses(@RequestBody DtoTimetable dtoTimetable) {
        Timetable timetable = new Timetable();
        timetable.setStartTime(LocalTime.parse(dtoTimetable.getStartTime()));
        timetable.setEndTime(LocalTime.parse(dtoTimetable.getEndTime()));
        timetable.setScheduledDate(Date.valueOf(dtoTimetable.getScheduledDate()));
        timetable.setClassRoom(dtoTimetable.getClassRoom());
        timetable.setModule(dtoTimetable.getModules());
        timetable.setBatches(dtoTimetable.getBatches());

        timetableService.getAllTimetables();
        return ResponseEntity.ok(dtoTimetable);
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

    @PostMapping("/AdminAddModule")
    public ResponseEntity<?> ModuleRegister(@RequestBody ModuleDTO dto) throws ModuleIdExistException {
        moduleService.createModule(dto);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/AdminScheduleTimetable")
    public ResponseEntity<?> scheduleTimetable(@RequestBody TimetableDto dto) throws Exception {

        TimetableDTO timetableDto = new TimetableDTO();
        timetableDto.setTimetableId(dto.getTimetableId());
        timetableDto.setStartTime(dto.getStartTime());
        timetableDto.setEndTime(dto.getEndTime());

        Module module = new Module();
        module.setModuleID(dto.getModules().getModuleID());

        List<BatchDto> batches = dto.getBatches();
        List<Batch> batchList = new ArrayList<>();
        for(BatchDto batch:batches){
            batchList.add(batchService.getBatchById(batch.getBatchID()));
        }

        ClassRoom classRoom= new ClassRoom();
        classRoom.setClassRoomID(dto.getClassRoom().getClassRoomID());
        classRoom.setAc(dto.getClassRoom().getAc());
        classRoom.setCapacity(dto.getClassRoom().getCapacity());
        classRoom.setSmartBoard(dto.getClassRoom().getSmartBoard());

        timetableDto.setScheduledDate(dto.getScheduledDate());
        timetableDto.setClassRoom(classRoom);
        timetableDto.setModules(module);
        timetableDto.setBatches(batchList);

        timetableService.createTimetable(timetableDto);

      return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/AdminCancelTimetable")
    public ResponseEntity<?> cancelScheduledClasses(@RequestBody TimetableDto timetabledto) {

        TimetableDTO timetables = timetableService.getTimetableById(timetabledto.getTimetableId());

        Timetable timetable= new Timetable();

        timetable.setTimetableId(timetables.getTimetableId());
        timetable.setScheduledDate(Date.valueOf(timetables.getScheduledDate().toString()));
        timetable.setStartTime(LocalTime.parse(timetables.getStartTime()));
        timetable.setEndTime(LocalTime.parse(timetables.getEndTime()));
        timetable.setBatches(timetables.getBatches());
        timetable.setClassRoom(timetables.getClassRoom());
        timetable.setModule(timetables.getModules());

        timetableService.cancelScheduledClass(timetable);
        return ResponseEntity.ok("Deleted Successfully!");
    }

    @DeleteMapping("/adminRemoveClassroom")
    public ResponseEntity<?> deleteClass(@RequestBody ClassRoom classRoom) {
        classRoomService.deleteClassRoom(classRoom);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/adminDeleteLec")
    public ResponseEntity<?> removeLecturer(@RequestBody User user) {
        userService.removeUser(user);
        return ResponseEntity.ok("User Removed Successfully!");
    }

    @DeleteMapping("/adminDeleteModule")
    public ResponseEntity<?> deleteModules(@RequestBody Module moduleId) {
        moduleService.deleteModules(moduleId);
        return ResponseEntity.ok("Module Deleted Successfully!");
    }


    @DeleteMapping("/adminDeleteBatch")
    public ResponseEntity<?> removeBatch(@RequestBody Batch batchId) {
        batchService.deleteBatch(batchId);
        return ResponseEntity.ok("Batch Deleted");
    }

    @PostMapping("/adminReschedulingClasses")
    public ResponseEntity<?> reScheduleClasses(@RequestBody TimetableDTO dto) throws Exception {
        timetableService.reScheduleTimetable(dto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/UpdateAdminAccount")
    public ResponseEntity<?> updateAdminAccount(User user) {
        userService.updateUserInfo(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/adminSearchBatches/{keyword}")
    public  ResponseEntity<?> searchBatches(@PathVariable("keyword")String name) {
        List<BatchDTO> batches = batchService.searchBatches(name);
        return  ResponseEntity.ok(batches);
    }

    @GetMapping("/adminSearchModules/{keyword}")
    public ResponseEntity<?> searchModules(@PathVariable("keyword")String name) {
        List<ModuleDTO> modules = moduleService.searchModules(name);
        return ResponseEntity.ok(modules);
    }
}