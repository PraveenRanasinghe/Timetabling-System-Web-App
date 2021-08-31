package com.timetabling.demo.service;

import com.timetabling.demo.dto.TimetableDTO;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.Timetable;
import org.h2.index.Index;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class TimetableServiceTest {

    @Autowired
    TimetableService timetableService;

    @Test
    public void getAllTimetables(){
        List<Timetable> timetableList = timetableService.getAllTimetables();
        assertThat(timetableList,not(IsEmptyCollection.empty()));
    }

    @Test
    public void getLecturerTimetables(String email){
        List<Timetable> timetableList = timetableService.getLecTimetables(email);
        assertThat(timetableList,not(IsEmptyCollection.empty()));
    }

    @Test
    public void getStudentTimetables(Batch batch){
        List<Timetable> timetableList = timetableService.getStudentTimetables(batch);
        assertThat(timetableList,not(IsEmptyCollection.empty()));
    }

    @Test
    public void getTodayTimetableToLecturer(String email, Date date){
        List<Timetable> timetableList = timetableService.getTodaysTimetableToLec(email,date);
        assertThat(timetableList,not(IsEmptyCollection.empty()));
    }

    @Test
    public void getTodayTimetableToStudent(Batch batch, Date date){
        List<Timetable> timetableList = timetableService.getTodaysTimetableToStudent(batch,date);
        assertThat(timetableList,not(IsEmptyCollection.empty()));
    }

    @Test
    public void getTimetableById(int id){
        TimetableDTO dto = timetableService.getTimetableById(id);
//        assertThat(dto,not());
    }
}
