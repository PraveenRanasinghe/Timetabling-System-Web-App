package com.timetabling.demo.repositary;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends JpaRepository<Batch, String> {

}
