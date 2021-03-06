package com.timetabling.demo.mobile.mobileController;

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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MobileStudentController {
    @Autowired
    private UserService userService;

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private ModuleService moduleService;


    @GetMapping("/getStudentAccount")
    public ResponseEntity<?> getStudent(Authentication auth) {
        User u = userService.getUserByID(auth.getName());
        return ResponseEntity.ok(u);
    }


    @GetMapping("/batchModules")
    public ResponseEntity<?> getBatchModules(Authentication auth){
        List<Module> allModules = moduleService.getModulesInBatch(userService.getUserByID(auth.getName()).getBatch());
        return ResponseEntity.ok(allModules);
    }

    @GetMapping("/todayLecturersForStudent")
    public ResponseEntity<?> getTodayTimetableToStudent(Authentication auth){
        long date= System.currentTimeMillis();
        Date currentDate= new Date(date);
        List<Timetable> timetables= timetableService.getTodaysTimetableToStudent(userService.getUserByID(auth.getName()).getBatch(),currentDate);

        List<TimetableDto> dtoList = new ArrayList<>();
        for(Timetable timetable:timetables){
            TimetableDto dto = new TimetableDto();
            ClassroomDto classroomDto= new ClassroomDto();
            ModuleDto moduleDto = new ModuleDto();

            dto.setStartTime(timetable.getStartTime().toString());
            dto.setEndTime(timetable.getEndTime().toString());
            dto.setScheduledDate(timetable.getScheduledDate());
            classroomDto.setClassRoomID(timetable.getClassRoom().getClassRoomID());
            dto.setClassRoom(classroomDto);
            moduleDto.setModuleName(timetable.getModule().toString());
            dto.setModules(moduleDto);
            dtoList.add(dto);
            System.out.println(auth.getName());
        }
        return ResponseEntity.ok(dtoList);
    }



    @GetMapping(path = "/allTimetablesForStudent")
    public ResponseEntity<?> studentTimetable(Authentication auth) {

        List<Timetable> allTimetables = timetableService.getStudentTimetables(userService.getUserByID(auth.getName()).getBatch());
        List<TimetableDto> dtoList = new ArrayList<>();

        for(Timetable timetables :allTimetables){
            TimetableDto dto = new TimetableDto();
            ClassroomDto classroomDto= new ClassroomDto();
            ModuleDto moduleDto = new ModuleDto();
            dto.setStartTime(timetables.getStartTime().toString());
            dto.setEndTime(timetables.getEndTime().toString());
            dto.setScheduledDate(timetables.getScheduledDate());
            classroomDto.setClassRoomID(timetables.getClassRoom().getClassRoomID());
            dto.setClassRoom(classroomDto);
            moduleDto.setModuleName(timetables.getModule().toString());
            dto.setModules(moduleDto);
            dtoList.add(dto);
        }

        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("/UpdateStudentAccount")
    public ResponseEntity<?> updateAdminAccount(@RequestBody User user) {
        userService.updateUserInfo(user);
        return ResponseEntity.ok(user);
    }


}
