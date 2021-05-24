package com.timetabling.demo.repositary;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimetableRepo extends JpaRepository<Timetable, Integer> {

    List<Timetable> findTimetablesByModule_User_Email(String email);

    List<Timetable> findTimetablesByBatchesEquals(Batch batch);

}
