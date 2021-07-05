package com.timetabling.demo.repositary;

import com.timetabling.demo.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepo extends JpaRepository<ClassRoom,String>{
}
