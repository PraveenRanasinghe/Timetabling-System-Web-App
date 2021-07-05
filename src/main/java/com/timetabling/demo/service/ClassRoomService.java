package com.timetabling.demo.service;

import com.timetabling.demo.dto.batchDTO;
import com.timetabling.demo.dto.classRoomDTO;
import com.timetabling.demo.dto.moduleDTO;
import com.timetabling.demo.exceptions.classRoomIdExistException;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.ClassRoom;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.repositary.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<classRoomDTO> getAllClassRoomsToList(){
        List<classRoomDTO> list= new ArrayList<>();
        for(ClassRoom classRoom: classroomRepo.findAll()){
            classRoomDTO dto= new classRoomDTO();
            dto.setClassRoomID(classRoom.getClassRoomID());
            dto.setCapacity(classRoom.getCapacity());
            list.add(dto);
        }
        return list;
    }


    public List<ClassRoom> getAllClassRooms(){
        return classroomRepo.findAll();
    }

    public ClassRoom addClassRoom(classRoomDTO dtoclass) throws classRoomIdExistException {
        ClassRoom room= new ClassRoom();
        if(classroomRepo.findById(dtoclass.getClassRoomID()).isPresent()){
            throw new classRoomIdExistException("ClassRoom Id is already used. Please try with another ClassRoom Id.");
        }
        else {
            room.setClassRoomID(dtoclass.getClassRoomID());
            room.setAc(dtoclass.getAc());
            room.setCapacity(dtoclass.getCapacity());
            room.setSmartBoard(dtoclass.getSmartBoard());
        }
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

    public void deleteClassRoom(ClassRoom classRoom){
        classroomRepo.delete(classRoom);
    }


}
