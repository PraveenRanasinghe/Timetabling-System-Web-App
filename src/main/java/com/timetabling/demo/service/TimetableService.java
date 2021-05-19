package com.timetabling.demo.service;

import com.sun.deploy.net.HttpResponse;
import com.timetabling.demo.dto.timetableDTO;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.repositary.TimetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {
    @Autowired
    private TimetableRepo timetableRepo;


    public List<Timetable> getAllTimetables(){
        return timetableRepo.findAll();
    }

    public Timetable createTimetable(timetableDTO dtoTimetable){
        Timetable timetables= new Timetable();
        timetables.setTimetableId(dtoTimetable.getTimetableId());
        timetables.setBatches(dtoTimetable.getBatches());
        timetables.setModule(dtoTimetable.getModules());
        timetables.setClassRoom(dtoTimetable.getClassRoom());
        timetables.setScheduledDate(dtoTimetable.getScheduledDate());
        timetables.setStartTime(LocalTime.parse(dtoTimetable.getStartTime()));
        timetables.setEndTime(LocalTime.parse(dtoTimetable.getEndTime()));
        return timetableRepo.save(timetables);
    }


    public Timetable getTimetableById(int tId){
        Optional<Timetable> timetable= timetableRepo.findById(tId);
        Timetable timetables= null;
        if(timetable.isPresent()){
            timetables=timetable.get();
        }
        return timetables;
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

}
