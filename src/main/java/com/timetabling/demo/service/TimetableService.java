package com.timetabling.demo.service;

//import com.sun.deploy.net.HttpResponse;
import com.timetabling.demo.dto.TimetableDTO;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.repositary.BatchRepo;
import com.timetabling.demo.repositary.ModuleRepo;
import com.timetabling.demo.repositary.TimetableRepo;
import com.timetabling.demo.repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Timetable> getTodaysTimetableToStudent(Batch batchId, Date date){
        return timetableRepo.findTimetablesByBatchesEqualsAndScheduledDate(batchId,date);
    }

    public List<Timetable> getTodaysTimetableToLec(String email, Date date){
        return timetableRepo.findTimetablesByModule_User_EmailAndScheduledDate(email,date);
    }


    public TimetableDTO getTimetableById(int tId) {
        Optional<Timetable> timetable = timetableRepo.findById(tId);
        TimetableDTO timetables = null;
        TimetableDTO dto = new TimetableDTO();
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
    public Timetable createTimetable(TimetableDTO dtoTimetable) throws Exception {

        Timetable timetables = new Timetable();
        List<Batch> batchList = new ArrayList();
        List<Timetable> timetableList = timetableRepo.findTimetablesByClassRoomAndScheduledDate(dtoTimetable.getClassRoom(),dtoTimetable.getScheduledDate());

        for(Timetable timetableData: timetableList){
            if((LocalTime.parse((dtoTimetable.getStartTime())).isAfter(timetableData.getStartTime()))
            && (LocalTime.parse((dtoTimetable.getStartTime())).isBefore(timetableData.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because selected classroom is already Booked!");
            }
            else if((LocalTime.parse((dtoTimetable.getEndTime())).isAfter(timetableData.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getEndTime())).isBefore(timetableData.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because selected classroom is already Booked!");
            }
        }

        Module module = moduleRepo.findById(dtoTimetable.getModules().getModuleID()).get();
        List<Timetable> timetableListToLec =
                timetableRepo.findTimetablesByModule_User_EmailAndScheduledDate(module.getUser().getEmail(),dtoTimetable.getScheduledDate());

        for(Timetable timetable:timetableListToLec){
            if((LocalTime.parse((dtoTimetable.getStartTime())).isAfter(timetable.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getStartTime())).isBefore(timetable.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because Lecturer is not available at that time!");
            }
            else if((LocalTime.parse((dtoTimetable.getEndTime())).isAfter(timetable.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getEndTime())).isBefore(timetable.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because Lecturer is not available at that time!");
            }
        }

        List<Timetable> timetableListToBatch=
                timetableRepo.findTimetablesByBatchesAndScheduledDate(batchRepo.getOne(dtoTimetable.getBatches().toString()),dtoTimetable.getScheduledDate());
        for(Timetable timetable:timetableListToBatch){
            if((LocalTime.parse((dtoTimetable.getStartTime())).isAfter(timetable.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getStartTime())).isBefore(timetable.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because selected Batches having lecturers on that time!");
            }
            else if((LocalTime.parse((dtoTimetable.getEndTime())).isAfter(timetable.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getEndTime())).isBefore(timetable.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because selected Batches having lecturers on that time!");
            }
        }

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


    public Timetable reScheduleTimetable(TimetableDTO dtoTimetable) throws Exception {
        Timetable timetables = timetableRepo.findById(dtoTimetable.getTimetableId()).orElseThrow(RuntimeException::new);
        List<Timetable> timetableList = timetableRepo.findTimetablesByClassRoomAndScheduledDate(dtoTimetable.getClassRoom(),dtoTimetable.getScheduledDate());
        for(Timetable timetableData: timetableList){
            if((LocalTime.parse((dtoTimetable.getStartTime())).isAfter(timetableData.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getStartTime())).isBefore(timetableData.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because selected classroom is already Booked!");
            }
            else if((LocalTime.parse((dtoTimetable.getEndTime())).isAfter(timetableData.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getEndTime())).isBefore(timetableData.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because selected classroom is already Booked!");
            }
        }
//        Module module = moduleRepo.findById(dtoTimetable.getModules().getModuleID()).get();
        List<Timetable> timetableListToLec =
                timetableRepo.findTimetablesByModule_User_EmailAndScheduledDate(dtoTimetable.getModules().getUser().getEmail(),dtoTimetable.getScheduledDate());

        for(Timetable timetable:timetableListToLec){
            if((LocalTime.parse((dtoTimetable.getStartTime())).isAfter(timetable.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getStartTime())).isBefore(timetable.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because Lecturer is not available at that time!");
            }
            else if((LocalTime.parse((dtoTimetable.getEndTime())).isAfter(timetable.getStartTime()))
                    && (LocalTime.parse((dtoTimetable.getEndTime())).isBefore(timetable.getEndTime()))){
                throw new Exception("You cannot Schedule the Timetable at this time slot. Because Lecturer is not available at that time!");
            }
        }

//        Module module = moduleRepo.findById(dtoTimetable.getBatches().toString()).get();
//        List<Timetable> timetableListToBatch=
//                timetableRepo.findTimetablesByBatchesAndScheduledDate( ,dtoTimetable.getScheduledDate());
//        for(Timetable timetable:timetableListToBatch){
//            if((LocalTime.parse((dtoTimetable.getStartTime())).isAfter(timetable.getStartTime()))
//                    && (LocalTime.parse((dtoTimetable.getStartTime())).isBefore(timetable.getEndTime()))){
//                throw new Exception("You cannot Schedule the Timetable at this time slot. Because selected Batches having lecturers on that time!");
//            }
//            else if((LocalTime.parse((dtoTimetable.getEndTime())).isAfter(timetable.getStartTime()))
//                    && (LocalTime.parse((dtoTimetable.getEndTime())).isBefore(timetable.getEndTime()))){
//                throw new Exception("You cannot Schedule the Timetable at this time slot. Because selected Batches having lecturers on that time!");
//            }
//        }

        timetables.setScheduledDate(new Date(dtoTimetable.getScheduledDate().getTime()));
        timetables.setStartTime(LocalTime.parse(dtoTimetable.getStartTime()));
        timetables.setEndTime(LocalTime.parse(dtoTimetable.getEndTime()));
        return timetableRepo.save(timetables);
    }


    public void cancelScheduledClass(Timetable timetable) {
        timetableRepo.delete(timetable);
    }


}


