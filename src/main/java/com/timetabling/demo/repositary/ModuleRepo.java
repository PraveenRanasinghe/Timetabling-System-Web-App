package com.timetabling.demo.repositary;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepo extends JpaRepository<Module, String> {

    List<Module> findModulesByBatchesEquals(Batch batchId);

    List<Module> findModulesByUserEmail_Email(String email);

    List<Module> findModuleByUserEmail(String email);

    @Query("FROM Module module WHERE module.moduleName LIKE %:moduleNames%")
    List<Module> getModuleName(String moduleNames);

}
