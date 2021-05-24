package com.timetabling.demo.service;

import com.sun.deploy.net.HttpResponse;
import com.timetabling.demo.dto.timetableDTO;
import com.timetabling.demo.dto.userDTO;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.model.User;
import com.timetabling.demo.repositary.BatchRepo;
import com.timetabling.demo.repositary.ModuleRepo;
import com.timetabling.demo.repositary.TimetableRepo;
import com.timetabling.demo.repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {
    @Autowired
    private TimetableRepo timetableRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModuleRepo moduleRepo;
    @Autowired
    private UserService userService;

    public List<Timetable> getAllTimetables() {
        return timetableRepo.findAll();
    }

    public List<Timetable> getLecTimetables(String email){
        return timetableRepo.findTimetablesByModule_User_Email(email);
    }

    public List<Timetable> getStudentTimetables(Batch batchId){
        return timetableRepo.findTimetablesByBatchesEquals(batchId);

    }


    public timetableDTO getTimetableById(int tId) {
        Optional<Timetable> timetable = timetableRepo.findById(tId);
        timetableDTO timetables = null;
        timetableDTO dto = new timetableDTO();
        if (timetable.isPresent()) {
            dto.setTimetableId(timetable.get().getTimetableId());
            dto.setScheduledDate(timetable.get().getScheduledDate());
            dto.setStartTime(timetable.get().getStartTime().toString());
            dto.setEndTime(timetable.get().getEndTime().toString());
            dto.setClassRoom(timetable.get().getClassRoom());
            dto.setModules(timetable.get().getModule());
            dto.setBatches(timetable.get().getBatches());
        }
        return dto;
    }



    @Transactional
    public Timetable createTimetable(timetableDTO dtoTimetable) {

        Timetable timetables = new Timetable();
        List<Batch> batchList = new ArrayList();

        timetables.setTimetableId(dtoTimetable.getTimetableId());

        for (Batch batches : dtoTimetable.getBatches()) {
            batchList.add(batchRepo.findById(batches.getBatchID()).get());
        }
        timetables.setBatches(batchList);

        timetables.setModule(moduleRepo.getOne(dtoTimetable.getModules().getModuleID()));
        timetables.setClassRoom(dtoTimetable.getClassRoom());
        timetables.setScheduledDate(new Date(dtoTimetable.getScheduledDate().getTime()));
        timetables.setStartTime(LocalTime.parse(dtoTimetable.getStartTime()));
        timetables.setEndTime(LocalTime.parse(dtoTimetable.getEndTime()));
        return timetableRepo.save(timetables);
    }



    public Timetable reScheduleTimetable(timetableDTO dtoTimetable) {
        Timetable timetables = timetableRepo.findById(dtoTimetable.getTimetableId()).orElseThrow(RuntimeException::new);
        timetables.setScheduledDate(new Date(dtoTimetable.getScheduledDate().getTime()));
        timetables.setStartTime(LocalTime.parse(dtoTimetable.getStartTime()));
        timetables.setEndTime(LocalTime.parse(dtoTimetable.getEndTime()));
        return timetableRepo.save(timetables);
    }


    public void cancelScheduledClass(Timetable timetable) {
        timetableRepo.delete(timetable);
    }



}


//    public Timetable updateTimetableInfo(timetableDTO dtoTimetable){
//        Timetable timetables= new Timetable();
//        timetables.setTimetableId(dtoTimetable.getTimetableId());
//        timetables.setBatch(dtoTimetable.getBatch());
//        timetables.setModuleName(dtoTimetable.getModuleName());
//        timetables.setClassRoom(dtoTimetable.getClassRoom());
//        timetables.setUser(dtoTimetable.getUser());
//        timetables.setScheduledDate(dtoTimetable.getScheduledDate());
//        timetables.setStartTime(LocalTime.parse(dtoTimetable.getStartTime()));
//        timetables.setEndTime(LocalTime.parse(dtoTimetable.getEndTime()));
//        return timetableRepo.save(timetables);
//    }
