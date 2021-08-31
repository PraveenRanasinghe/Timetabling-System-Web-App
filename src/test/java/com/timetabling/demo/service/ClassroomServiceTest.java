package com.timetabling.demo.service;
import com.timetabling.demo.dto.ClassRoomDTO;
import com.timetabling.demo.model.ClassRoom;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ClassroomServiceTest {

    @Autowired
    ClassRoomService classRoomService;

    @Test
    public void getAllClasses(){
        List<ClassRoom> allClasses = classRoomService.getAllClassRooms();
        assertThat(allClasses,not(IsEmptyCollection.empty()));
    }

    @Test
    public void getClassList(){
        List<ClassRoomDTO> classRoomDTOS = classRoomService.getAllClassRoomsToList();
        assertThat(classRoomDTOS,not(IsEmptyCollection.empty()));
    }



}
