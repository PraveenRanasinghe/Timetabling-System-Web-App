package com.timetabling.demo.repositary;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.Timetable;
import com.timetabling.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepo extends JpaRepository<Batch, String> {

    @Query("FROM Batch batch WHERE batch.batchName LIKE %:batchName%")
    List<Batch> searchBatchName(String batchName);

}
