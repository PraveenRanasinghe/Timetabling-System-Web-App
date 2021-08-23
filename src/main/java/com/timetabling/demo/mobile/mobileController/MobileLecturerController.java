package com.timetabling.demo.mobile.mobileController;


import com.timetabling.demo.mobile.mobileModel.BatchDto;
import com.timetabling.demo.mobile.mobileModel.ClassroomDto;
import com.timetabling.demo.mobile.mobileModel.ModuleDto;
import com.timetabling.demo.mobile.mobileModel.TimetableDto;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.model.User;
import com.timetabling.demo.service.ModuleService;
import com.timetabling.demo.service.TimetableService;
import com.timetabling.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MobileLecturerController {

    @Autowired
    private UserService userService;

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private ModuleService moduleService;


    @GetMapping("/getLecturerAccount")
    public ResponseEntity<?> getLecturer(Authentication auth) {
        User u = userService.getUserByID(auth.getName());
        return ResponseEntity.ok(u);
    }

    @GetMapping("/myModules")
    public ResponseEntity<?> getLecModules(Authentication auth){
        List<Module> allModules=moduleService.getLecturerModules(userService.getUserByID(auth.getName()).getEmail());
        return ResponseEntity.ok(allModules);
    }

    @GetMapping("/todayLecturersForLecturer")
    public ResponseEntity<?> getTodaysTimetableToLec(Authentication auth){
        long date= System.currentTimeMillis();
        java.sql.Date currentDate= new java.sql.Date(date);

        List<Timetable> timetableList= timetableService.getTodaysTimetableToLec(userService.getUserByID(auth.getName()).getEmail(),currentDate);
        List<TimetableDto> dtoList = new ArrayList<>();
        for(Timetable timetable:timetableList){
            TimetableDto dto = new TimetableDto();
            ClassroomDto classroomDto= new ClassroomDto();
            BatchDto batchDto = new BatchDto();
            ModuleDto moduleDto = new ModuleDto();

            dto.setStartTime(timetable.getStartTime().toString());
            dto.setEndTime(timetable.getEndTime().toString());
            dto.setScheduledDate(timetable.getScheduledDate());
            classroomDto.setClassRoomID(timetable.getClassRoom().getClassRoomID());
            dto.setClassRoom(classroomDto);
            moduleDto.setModuleName(timetable.getModule().getModuleName());
            dto.setModules(moduleDto);
            dtoList.add(dto);
        }
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/allTimetablesForLecturer")
    public ResponseEntity<?> getLecTimetables(Authentication auth) {
        List<Timetable> allTimetables = timetableService.getLecTimetables(auth.getName());
        List<TimetableDto> dtoList = new ArrayList<>();
        for(Timetable timetable:allTimetables){
            TimetableDto dto = new TimetableDto();
            ClassroomDto classroomDto= new ClassroomDto();
            ModuleDto moduleDto = new ModuleDto();

            dto.setStartTime(timetable.getStartTime().toString());
            dto.setEndTime(timetable.getEndTime().toString());
            dto.setScheduledDate(timetable.getScheduledDate());
            classroomDto.setClassRoomID(timetable.getClassRoom().getClassRoomID());
            dto.setClassRoom(classroomDto);
            moduleDto.setModuleName(timetable.getModule().getModuleName());
            dto.setModules(moduleDto);
            dtoList.add(dto);
        }
        return ResponseEntity.ok(dtoList);
    }





}
