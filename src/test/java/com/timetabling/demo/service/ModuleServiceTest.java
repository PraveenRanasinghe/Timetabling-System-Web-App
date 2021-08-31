package com.timetabling.demo.service;

import com.timetabling.demo.dto.ModuleDTO;
import com.timetabling.demo.model.Module;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ModuleServiceTest {

    @Autowired
    ModuleService moduleService;

    @Test
    public void getAllModules(){
        List<Module> modules = moduleService.getAllModules();
        assertThat(modules,not(IsEmptyCollection.empty()));
    }

    @Test
    public void getModuleList(){
        List<ModuleDTO> moduleList = moduleService.getAllModulesToList();
        assertThat(moduleList,not(IsEmptyCollection.empty()));
    }

}
