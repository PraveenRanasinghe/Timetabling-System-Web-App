package com.timetabling.demo.repositary;

import com.timetabling.demo.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimetableRepo extends JpaRepository<Timetable, Integer> {
}
