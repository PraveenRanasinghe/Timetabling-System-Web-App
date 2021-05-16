package com.timetabling.demo.service;

import com.timetabling.demo.dto.classRoomDTO;
import com.timetabling.demo.dto.moduleDTO;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.ClassRoom;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.repositary.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    private ClassroomRepo classroomRepo;

    public ClassRoom getClassRoomById(String cId){
        Optional<ClassRoom> classRoom= classroomRepo.findById(cId);
        ClassRoom cr=null;
        if(classRoom.isPresent()){
            cr=classRoom.get();
        }
        return cr;
    }

    public List<ClassRoom> getAllClassRooms(){
        return classroomRepo.findAll();
    }

    public ClassRoom addClassRoom(classRoomDTO dtoclass){

        ClassRoom room= new ClassRoom();
        room.setClassRoomID(dtoclass.getClassRoomID());
        room.setAc(dtoclass.getAc());
        room.setCapacity(dtoclass.getCapacity());
        room.setSmartBoard(dtoclass.getSmartBoard());
        return classroomRepo.save(room);
    }

    public ClassRoom updateClassRoom(classRoomDTO dtoclass){

        ClassRoom room= new ClassRoom();
        room.setClassRoomID(dtoclass.getClassRoomID());
        room.setAc(dtoclass.getAc());
        room.setCapacity(dtoclass.getCapacity());
        room.setSmartBoard(dtoclass.getSmartBoard());
        return classroomRepo.save(room);
    }
}
